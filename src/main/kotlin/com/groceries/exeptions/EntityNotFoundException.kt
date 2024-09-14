package com.groceries.exeptions

class EntityNotFoundException(entity: String) : RuntimeException("$entity not found")