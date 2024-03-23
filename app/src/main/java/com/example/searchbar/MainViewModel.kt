package com.example.searchbar

import androidx.lifecycle.ViewModel
import com.example.searchbar.data.Account
import com.example.searchbar.data.allAccounts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private var _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private var _allAccounts = MutableStateFlow(allAccounts)
    var allAccount: StateFlow<List<Account>> = _allAccounts



}