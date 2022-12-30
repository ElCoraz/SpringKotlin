package com.application.execute.model

import lombok.*

/**********************************************************************************************************************/
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Asserts (
        val head: List<Assert>,
        val footer: List<Assert>
)
/**********************************************************************************************************************/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Assert (
        val head: Boolean,
        val path: String
)