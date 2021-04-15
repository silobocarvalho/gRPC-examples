package br.com.zup.ot2

fun main() {
    val request = EmployeeRequest.newBuilder()
        .setName("Sidartha Carvalho")
        .setCpf("12345678909")
        .setRole(Role.DEV)
        .setActive(true)
        .addAddress(EmployeeRequest.Address.newBuilder()
            .setStreet("Zuppers street")
            .setZipcode("63907-004").build()).build()

    println(request)
}