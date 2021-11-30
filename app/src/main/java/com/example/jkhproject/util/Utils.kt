package com.example.jkhproject.util

class Utils {
    companion object {
        fun getDateTime(s: String): String {
            val result = ""
            val date = s.split("T")[0]
            val year = date.split("-")[0]
            val month = date.split("-")[1]
            val day = date.split("-")[2]
            return "$day.$month.$year"
        }
    }
}
