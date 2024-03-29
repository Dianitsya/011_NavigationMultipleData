package com.example.latihan8

import androidx.lifecycle.ViewModel
import com.example.latihan8.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat


private const val Harga_Per_Cup = 3000

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()


    fun setJumlah(jmlEsJumbo: Int) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)
            )
        }
    }

    fun setRasa(rasaPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan)
        }
    }

    fun resetOrder() {
        _stateUI.value = OrderUIState()
    }

    private fun hitungHarga(
        jumlah: Int = _stateUI.value.jumlah,
    ): String {
        val kalkulasiHarga = jumlah * Harga_Per_Cup

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }

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
