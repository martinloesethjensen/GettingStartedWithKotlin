package com.rsk.java.kotlin

import java.lang.Exception

class Meeting(val title: String) {
    var location = ""
    @JvmField
    var description = ""

    @Throws(MeetingException::class)
    fun addAttendee(attendee: String){
        if (attendee.isNullOrEmpty()) throw MeetingException("Attendee must have a name")
    }

    companion object {
        @JvmField
        val APP_VERSION = 1

        @JvmStatic
        fun getAppVersion(): Int {
            return APP_VERSION
        }
    }
}

class MeetingException(message: String) : Exception(message)