package net.radityalabs.alquran.data.di.component

import net.radityalabs.alquran.data.network.RestService
import net.radityalabs.alquran.data.network.RetrofitHelper

interface HttpComponent {
    fun retrofitHelper(): RetrofitHelper

    fun restService(): RestService
}