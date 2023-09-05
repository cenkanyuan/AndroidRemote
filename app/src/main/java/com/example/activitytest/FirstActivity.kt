package com.example.activitytest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = FirstLayoutBinding.inflate(LayoutInflater.from(this))//使用ViewBinding写按键弹窗
        setContentView(binding.root)
        binding.button1.setOnClickListener {
//            Toast.makeText(this, "You clicked Button 1", Toast.LENGTH_SHORT).show()//弹窗
//            finish()//销毁当前activity
            val intent = Intent(this, SecondActivity::class.java)//启动目标activity,显式intent
            startActivity(intent)
//            val intent = Intent("com.example.activitytest.ACTION_START")//筛选并启动符合条件的activity，隐式intent
//            intent.addCategory("com.example.activitytest.MY_CATEGORY")//添加额外条件，条件在activity注册文件中设置
//            startActivity(intent)
//            val intent = Intent(Intent.ACTION_VIEW)//打开系统浏览器并转到百度
//            intent.data = Uri.parse("https://www.baidu.com")
//            startActivity(intent)

        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this, ForthActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {//隐藏式菜单
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent("com.example.activitytest.ACTION_START")
        when(item.itemId){
//            R.id.add_item->Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show()
            R.id.add_item->startActivity(intent)
            R.id.remove_item->Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}