package com.crycetruly.notekeeper

import androidx.test.InstrumentationRegistry.*
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getTargetContext()
        assertEquals("com.crycetruly.notekeeper", appContext.packageName)
    }
}
