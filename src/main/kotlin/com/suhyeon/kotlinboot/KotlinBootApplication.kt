package com.suhyeon.kotlinboot

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinBootApplication

fun main(args: Array<String>) {
	runApplication<KotlinBootApplication>(*args) {
		setBannerMode(Banner.Mode.OFF)
	}
}