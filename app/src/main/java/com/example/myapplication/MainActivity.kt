package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemAdapter = ItemAdapter()
        rvItem.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvItem.adapter = itemAdapter
        thread {
            getData().apply {
                for (item in this) {
                    item.output = calculateName(item.name)
                }
                runOnUiThread {
                    itemAdapter.setData(this)
                }
            }
        }
    }

    private fun calculateName(name: String): String {
        val result: String
        val middle = name.length / 2
        if (name[middle].isWhitespace()) {
            result = name.substring(0, middle).plus("\n").plus(name.substring(middle + 1, name.length))
        } else {
            var increase = middle
            var reduce = middle

            do {
                increase++
            } while (increase < name.length && !name[increase].isWhitespace())
            do {
                reduce--
            } while (reduce > 0 && !name[reduce].isWhitespace())

            val minStep: Int
            if (increase - middle < middle - reduce) {
                minStep = increase
            } else {
                minStep = reduce
            }
            if (!name[minStep].isWhitespace()) {
                result = name
            } else {
                result = name.substring(0, minStep).plus("\n").plus(name.substring(minStep + 1, name.length))
            }
        }
        return result
    }

    private fun getData() = listOf (
        Item().apply {
            name = "bánh trung thu"
        },
        Item().apply {
            name = "xiaomi"
        },
        Item().apply {
            name = "innisfree"
        },
        Item().apply {
            name = "balo"
        },
        Item().apply {
            name = "bitis hunter xx"
        },
        Item().apply {
            name = "bánh trung thu"
        },
        Item().apply {
            name = "tai nghe"
        },
        Item().apply {
            name = "anker"
        },
        Item().apply {
            name = "bánh trung thu kinh đô"
        },
        Item().apply {
            name = "bitis"
        },
        Item().apply {
            name = "bts"
        },
        Item().apply {
            name = "banh trung thu"
        },
        Item().apply {
            name = "son"
        },
        Item().apply {
            name = "tai nghe bluetooth"
        },
        Item().apply {
            name = "bình giữ nhiệt"
        },
        Item().apply {
            name = "harry potter"
        },
        Item().apply {
            name = "túi đeo chéo"
        },
        Item().apply {
            name = "đắc nhân tâm"
        },
        Item().apply {
            name = "laneige"
        },
        Item().apply {
            name = "sạc dự phòng"
        },
        Item().apply {
            name = "anh chính là thanh xuân của em"
        })
}
