package com.example.searchbar

import androidx.lifecycle.ViewModel
import com.example.searchbar.data.User
import com.example.searchbar.data.allUsers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private var _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private var _allAccounts = MutableStateFlow(allUsers)
    var allUser: StateFlow<List<User>> = _allAccounts



}