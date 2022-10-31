package com.example.desainpatrenmvvm

import com.example.desainpatrenmvvm.model.ResponseDataCarItem
import com.example.desainpatrenmvvm.network.RestfulApi
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class VMTest {
    lateinit var servis: RestfulApi

    @Before
    fun setUp() {
        servis = mockk()
    }

    @Test
    fun getCarTest(): Unit = runBlocking {

        val respAllCar = mockk<List<ResponseDataCarItem>>()

        every {
            runBlocking {
                servis.getCar()
            }
        }returns respAllCar


        val result = servis.getCar()

        verify {
            runBlocking { servis.getCar() }
        }
        assertEquals(result, respAllCar)

    }
}