package com.demo.study

import android.os.Bundle
import com.chl.common.utils.LogUtil
import com.demo.study.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewBinding().btnKotlin.setOnClickListener {
            LogUtil.e("AAAA", "onClick : kotlin")
            KotlinActivity.openSelf(this@MainActivity)
        }
        getViewBinding().btnSet.setOnClickListener {
            LogUtil.e("AAAA","onClick : set : $it")
            SetActivity.openSelf(this@MainActivity)
        }
        getViewBinding().btnData.setOnClickListener { DataActivity.openSelf(this@MainActivity) }

        getViewBinding().btnParseXml.setOnClickListener {
            StringParse.parseXml(this, R.layout.xml_test)
//            StringParse.parseXml(this, R.layout.xml_test2)
        }
        getViewBinding().btnStatusBar.setOnClickListener {
            StatusBarActivity.openSelf(this@MainActivity)
        }

        getViewBinding().btnLifecycle.setOnClickListener {
            LifecycleActivity.openSelf(this)
        }

    }

    override fun buildViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}