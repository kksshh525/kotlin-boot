package com.suhyeon.kotlinboot.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

/**
 * JUnit 5 allows to inject constructor and method parameters, which is a good fit with Kotlin
 * read-only and non-nullable properties
 *
 * we will use a property file to change the default behavior for the whole project:
 *   src/test/resources/junit-platform.properties
 * With this configuration, we can now use @BeforeAll and @AfterAll annotations on regular methods
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HtmlControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    /**
     * We use real sentences between backticks instead of camel-case to provide expressive test
     * function names
     *
     * This code leverages getForObject and getForEntity Kotlin extensions (you need to import them)
     */
    @Test
    fun `Assert blog page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>Blog</h1>")
    }

    @Test
    fun `Assert article page title, content and status code`() {
        println(">> TODO")
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}