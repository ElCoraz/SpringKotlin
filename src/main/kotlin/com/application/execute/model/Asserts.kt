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
        val head: Boolean,
        val path: String
)