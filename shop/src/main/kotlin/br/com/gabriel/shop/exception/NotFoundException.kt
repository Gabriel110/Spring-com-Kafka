package br.com.gabriel.shop.exception

import java.lang.RuntimeException

class NotFoundException(message: String?) : RuntimeException(message)