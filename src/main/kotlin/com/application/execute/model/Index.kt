package com.application.execute.model

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter

@Getter
@Setter
class Index {
    @JsonProperty("greeting")
    lateinit var greeting:String
    @JsonProperty("change")
    lateinit var change:String
    @JsonProperty("en")
    lateinit var en:String
    @JsonProperty("ru")
    lateinit var ru:String
}