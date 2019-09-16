package com.jeevan.byjus

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

object Utils {
    fun getFormattedDate(dateString: String): String {
        val date = LocalDate.parse(dateString, DateTimeFormatter.ISO_ZONED_DATE_TIME)
        return date.toString()
    }
}