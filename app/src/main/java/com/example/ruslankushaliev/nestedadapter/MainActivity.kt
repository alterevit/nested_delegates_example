package com.example.ruslankushaliev.nestedadapter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.ruslankushaliev.nestedadapter.ui.delegate.TopDelegate
import com.example.ruslankushaliev.nestedadapter.ui.entity.Nested
import com.example.ruslankushaliev.nestedadapter.ui.entity.Top
import com.example.ruslankushaliev.nestedadapter.ui.template.delegateadapter.RibbonAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mocTop get() = Top("First", listOf(Nested("Nested first"), Nested("Nested second"), Nested("Nested third")))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        recycler.adapter = RibbonAdapter(TopDelegate() to TOP_LEVEL).apply {
            refresh(mocTop, mocTop, mocTop, mocTop)
        }
    }
}
