package com.application.execute.service

import com.application.execute.model.Assert
import com.application.execute.model.Asserts
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

/**********************************************************************************************************************/
@Service
class AssertsService {
    /******************************************************************************************************************/
    fun asserts(): Asserts {
        return Asserts(headAsserts(), footerAsserts())
    }
    /******************************************************************************************************************/
    fun headAsserts(): List<Assert> {

        val path: Path = Paths.get("").toAbsolutePath()

        val list: ArrayList<Assert> = arrayListOf()

        val replace = "$path/src/main/resources/static/asserts"

        File("$path/src/main/resources/static/asserts").walkTopDown().forEach {
            if (it.isFile) {
                val file = it.toString().replace("\\", "/").replace(replace.replace("\\", "/"), "");
                if ((it.extension == "css") || (it.extension == ".map")) {
                    list.add(Assert(true, "/asserts$file"))
                }
            }
        }

        return list;
    }
    /******************************************************************************************************************/
    fun footerAsserts(): List<Assert> {

        val path: Path = Paths.get("").toAbsolutePath();

        val tmp: ArrayList<Assert> = arrayListOf()

        val replace = "$path/src/main/resources/static/asserts"

        File("$path/src/main/resources/static/asserts").walkTopDown().forEach {
            if (it.isFile) {
                val file = it.toString().replace("\\", "/").replace(replace.replace("\\", "/"), "");
                if (it.extension == "js") {
                    tmp.add(Assert(false,"/asserts$file"))
                }
            }
        }

        val list: ArrayList<Assert> = ArrayList()

        tmp.forEach {
            if (it.path.indexOf("jquery") > 0) {
                list.add(it)
            }
        }

        tmp.forEach {
            if (it.path.indexOf("bootstrap") > 0) {
                list.add(it)
            }
        }

        return list;
    }
    /******************************************************************************************************************/
}