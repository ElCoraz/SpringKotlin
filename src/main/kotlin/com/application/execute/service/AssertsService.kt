package com.application.execute.service

import com.application.execute.model.Asserts
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

/**********************************************************************************************************************/
@Service
class AssertsService {
    /******************************************************************************************************************/
    fun headAsserts(): List<Asserts> {

        val path: Path = Paths.get("").toAbsolutePath();

        val list: ArrayList<Asserts> = ArrayList()

        val replace = "$path/src/main/resources/static/asserts"

        File("$path/src/main/resources/static/asserts").walkTopDown().forEach {
            if (it.isFile) {
                val file = it.toString().replace("\\", "/").replace(replace.replace("\\", "/"), "");
                if ((it.extension == "css") || (it.extension == ".map")) {
                    list.add(Asserts(true, "/asserts$file"))
                }
            }
        }

        return list;
    }
    /******************************************************************************************************************/
    fun footerAsserts(): List<Asserts> {

        val path: Path = Paths.get("").toAbsolutePath();

        val tmp: ArrayList<Asserts> = ArrayList()

        val replace = "$path/src/main/resources/static/asserts"

        File("$path/src/main/resources/static/asserts").walkTopDown().forEach {
            if (it.isFile) {
                val file = it.toString().replace("\\", "/").replace(replace.replace("\\", "/"), "");
                if (it.extension == "js") {
                    tmp.add(Asserts(false,"/asserts$file"))
                }
            }
        }

        val list: ArrayList<Asserts> = ArrayList()

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