package com.groceries.exeptions

class BadRequestException(val reason: String) : RuntimeException(reason)