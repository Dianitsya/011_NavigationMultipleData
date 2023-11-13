package com.example.latihan8

import androidx.lifecycle.ViewModel
import com.example.latihan8.data.ContactUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContactViewModel : ViewModel()  {
    private val _stateUI = MutableStateFlow(ContactUIState())
    val stateUI: StateFlow<ContactUIState> = _stateUI.asStateFlow()

    fun setContact(listContact: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listContact[0],
                noTelp = listContact[1],
                alamat = listContact[2]
            )
        }
    }
}