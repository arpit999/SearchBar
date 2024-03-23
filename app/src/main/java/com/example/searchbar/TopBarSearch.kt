package com.example.searchbar

import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    DockedSearchBar(
        query = "", onQueryChange = {}, onSearch = {}, active = true, onActiveChange = {}, modifier = modifier
    ) {

        

    }
}

@Preview
@Composable
private fun PreviewSearchBar() {
    SearchBar()
}