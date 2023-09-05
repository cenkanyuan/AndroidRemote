package com.example.activitytest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.activitytest.databinding.SecondLayoutBinding
import com.shy.rockerview.MyRockerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = SecondLayoutBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val actionBar = supportActionBar//隐藏标题栏
        actionBar?.hide()

        //方向有改变时回调
        val mRockerView = binding.rockerXYView  // 8方向
        val directionText = binding.directionXYText    // 当前方向
        val angleText = binding.angleXYText   // 当前角度
        val levelText = binding.levelXYText    // 当前偏移级别

        // xy轴
        // 1方向
        mRockerView.setOnShakeListener(MyRockerView.DirectionMode.DIRECTION_8, object : MyRockerView.OnShakeListener {
            override fun onStart() {}
            override fun direction(direction: MyRockerView.Direction) {
                var directionXY  = when(direction){
                    MyRockerView.Direction.DIRECTION_CENTER -> "当前方向：中心"
                    MyRockerView.Direction.DIRECTION_DOWN -> "当前方向：下"
                    MyRockerView.Direction.DIRECTION_LEFT -> "当前方向：左"
                    MyRockerView.Direction.DIRECTION_UP -> "当前方向：上"
                    MyRockerView.Direction.DIRECTION_RIGHT -> "当前方向：右"
                    MyRockerView.Direction.DIRECTION_DOWN_LEFT -> "当前方向：左下"
                    MyRockerView.Direction.DIRECTION_DOWN_RIGHT -> "当前方向：右下"
                    MyRockerView.Direction.DIRECTION_UP_LEFT -> "当前方向：左上"
                    MyRockerView.Direction.DIRECTION_UP_RIGHT -> "当前方向：右上"
                }
                Log.e("SecondActivity", "XY轴$directionXY")
                Log.e("SecondActivity", "-----------------------------------------------")
                directionText.text = directionXY
            }
            override fun onFinish() {}
        })
        // 1角度
        mRockerView.setOnAngleChangeListener(object : MyRockerView.OnAngleChangeListener {
            override fun onStart() {}
            override fun angle(angle: Double) {
                var angleXY = ""
                angleXY = "当前角度：$angle"
                Log.e("SecondActivity", "XY轴$angleXY")
                angleText.text=(angleXY)
            }

            override fun onFinish() {}
        })
        // 1级别
        mRockerView.setOnDistanceLevelListener { level ->
            var levelXY = ""
            levelXY = "当前距离级别：$level"
            Log.e("SecondActivity", "XY轴$levelXY")
            levelText.text=(levelXY)

        }
    }
}