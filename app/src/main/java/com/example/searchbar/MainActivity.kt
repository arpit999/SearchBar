package com.example.searchbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.searchbar.data.User
import com.example.searchbar.data.generateDummyUser
import com.example.searchbar.ui.theme.SearchBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SearchBarTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SearchApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(16.dp)
    ) {

        var query by remember { mutableStateOf("") }
        var active by remember { mutableStateOf(false) }

        val userList by remember {
            val dummyUsers = (1..500).map { generateDummyUser(it.toLong()) }
            mutableStateOf(dummyUsers)
        }
        val searchResults = remember { mutableStateListOf<User>() }

        LaunchedEffect(query) {
            searchResults.clear()
            if (query.isNotEmpty()) {
                val filterAccounts = userList.filter {
                    it.firstName.startsWith(prefix = query, ignoreCase = true) || it.lastName.startsWith(
                        prefix = query,
                        ignoreCase = true
                    ) || it.email.startsWith(prefix = query, ignoreCase = true)
                }
                searchResults.addAll(filterAccounts)
            }
        }

        DockedSearchBar(
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            modifier = Modifier,
            placeholder = { Text(stringResource(R.string.search_user)) },
            leadingIcon = {
                if (active) {
                    IconButton(
                        modifier = Modifier.padding(start = 16.dp),
                        onClick = {
                            active = false
                            query = ""
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button),
                        )

                    }
                } else {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search),
                        modifier = Modifier.padding(start = 16.dp),
                    )
                }
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = stringResource(R.string.clear),
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable {
                                query = ""
                            },
                    )
                }
            }
        ) {

            when {
                searchResults.isNotEmpty() -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        items(searchResults, key = { it.id }) {
                            ListItem(
                                headlineContent = { Text(it.fullName) },
                                supportingContent = { Text(it.email) }
                            )
                        }
                    }
                }

                query.isNotEmpty() -> {
                    Text(
                        stringResource(R.string.no_item_found),
                        modifier = Modifier.padding(16.dp)
                    )
                }

                else -> {
                    Text(
                        text = stringResource(id = R.string.no_search),
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }

        }
    }
}


@Preview
@Composable
private fun PreviewSearchApp() {
    SearchBarTheme {
        Surface {
            SearchApp()
        }
    }
}