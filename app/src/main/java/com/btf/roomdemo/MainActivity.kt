package com.btf.roomdemo

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.btf.roomdemo.adapter.WordAdapter
import com.btf.roomdemo.dao.InnerJoinResult
import com.btf.roomdemo.database.DepartmentDatabase
import com.btf.roomdemo.entity.Department
import com.btf.roomdemo.entity.Employee
import com.btf.roomdemo.entity.Word
import com.btf.roomdemo.viewmodel.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: WordViewModel
    private val imgUrl =
        "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1587731618526&di=d397d0acbdad801242660124c0243392&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fc%2F59ba2f17bdffb.jpg"
    private lateinit var bitmap: Bitmap
    private lateinit var recyclerView: RecyclerView

    //private lateinit var switch1:Switch
    private lateinit var wordAdapter1: WordAdapter
    private lateinit var wordAdapter2: WordAdapter
    private var employees = arrayOf(
        Employee(name = "Paul", age = 32, address = "California", salary = 20000.0),
        Employee(name = "Allen", age = 25, address = "Texas", salary = 15000.0),
        Employee(name = "Teddy", age = 23, address = "Norway", salary = 20000.0),
        Employee(name = "Mark", age = 25, address = "Rich-Mond", salary = 65000.0),
        Employee(name = "David", age = 27, address = "Texas", salary = 85000.0),
        Employee(name = "Kim", age = 22, address = "South-Hall", salary = 45000.0),
        Employee(name = "James", age = 24, address = "Houston", salary = 10000.0)
    )
    private var departmentList = arrayOf(
        Department(dept = "IT Billing", empId = 1),
        Department(dept = "Engineerin", empId = 2),
        Department(dept = "Finance", empId = 7)
    )

    //private lateinit var userViewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(WordViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        wordAdapter1 = WordAdapter(false,viewModel)
        wordAdapter2 = WordAdapter(true,viewModel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = wordAdapter1

        switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                recyclerView.adapter = wordAdapter2
            }else{
                recyclerView.adapter = wordAdapter1
            }
        }*/

        //userViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(UserViewModel::class.java)


        /*viewModel.allWordsLive.observe(this, Observer {
            var temp = wordAdapter1.itemCount
            wordAdapter1.allWords = it
            wordAdapter2.allWords = it
            if(temp != it.size) {
                wordAdapter1.notifyDataSetChanged()
                wordAdapter2.notifyDataSetChanged()
            }
        })*/

        /*userViewModel.allUsers.observe(this, Observer {
            var text = ""
            for (user in it){
                text += "${user.id} : name is ${user.name} and the age is ${user.age} \n"
            }
            textView.text = text
        })*/
        /*CoroutineScope(Dispatchers.Main).launch {
            bitmap = getImage()
            imageView.setImageBitmap(getImage())
            val bitmap1 = async { cropBitmap(bitmap,4,0) }
            val bitmap2 = async { cropBitmap(bitmap,9,8) }
            imageView2.setImageBitmap(bitmap1.await())
            imageView3.setImageBitmap(bitmap2.await())
        }*/
    }


    /*suspend fun getImage():Bitmap = withContext(Dispatchers.IO){
        val connection:HttpURLConnection = URL(imgUrl).openConnection() as HttpURLConnection
        connection.run {
            requestMethod = "GET"
            connect()
            BitmapFactory.decodeStream(inputStream)
        }
    }*/

    /**
     * @bitmap 原始图片
     * @x x轴裁剪起始点
     * @y y轴裁剪起始点
     * @width 裁剪的宽度
     * @height 裁剪的高度
     */
    /*suspend fun cropBitmap(bitmap: Bitmap,x:Int,postX:Int):Bitmap = withContext(Dispatchers.IO){
        Bitmap.createBitmap(bitmap,bitmap.width*postX,0,bitmap.width/x,bitmap.height)
    }*/
    suspend fun getEmployees(): List<Employee> = withContext(Dispatchers.IO) {
        DepartmentDatabase.getInstance(this@MainActivity).employee().getAllEmployees()
    }

    suspend fun getDepartments(): List<Department> = withContext(Dispatchers.IO) {
        DepartmentDatabase.getInstance(this@MainActivity).departmentDao().getAllDepartments()
    }

    suspend fun getInnerJoinResult():List<InnerJoinResult> = withContext(Dispatchers.IO){
        DepartmentDatabase.getInstance(this@MainActivity).employee().getDepartmentFromEmployee()
    }

    fun click(view: View) {
        when (view) {
            btn_insert -> {
                /*val english = arrayOf("Hello","World","Android","Google","Studio","Project","Database","Recycler","View","String","Value","Integer")
                val chinese = arrayOf("你好","世界","安卓系统","谷歌公司","工作室","项目","数据库","回收站","视图","字符串","价值","整形类型")

                for (i in english.indices){
                    viewModel.insertWords(Word(word = english[i],chineseMeaning = chinese[i]))
                }*/
                /*CoroutineScope(Dispatchers.IO).launch {
                    DepartmentDatabase.getInstance(this@MainActivity).employee().insertEmployees(*employees)
                    DepartmentDatabase.getInstance(this@MainActivity).departmentDao().insertDepartments(*departmentList)
                }*/

                CoroutineScope(Dispatchers.IO).launch {
                    DepartmentDatabase.getInstance(this@MainActivity).employee()
                        .insertEmployees(*employees)
                    DepartmentDatabase.getInstance(this@MainActivity).departmentDao()
                        .insertDepartments(*departmentList)
                }

                /*var word1 = Word()
                word1.word = "Hello"
                word1.chineseMeaning = "你好！"
                var word2 = Word()
                word2.word = "World"
                word2.chineseMeaning = "世界！"

                val words = arrayOf(word1,word2)

                viewModel.insertWords(*words)*/

                /*var user1 = User()
                user1.name = "Jim"
                user1.age = 11
                var user2 = User()
                user2.name = "Tom"
                user2.age = 20

                userViewModel.insertUser(user1,user2)*/
            }

            btn_clear -> {
                /*CoroutineScope(Dispatchers.Main).launch {
                    var employees = getEmployees()
                    var departments = getDepartments()
                    println(" employees --------->  ${employees.size}")
                    for (em in employees) {
                        println("result --->  ${em.name}   ${em.age}  ${em.address}  ${em.salary}")
                    }
                    println("========================================= 分割线 ==================================")
                    println(" departments --------->  ${departments.size}")
                    for (dep in departments) {
                        println("result --->  ${dep.dept}   ${dep.empId}")
                    }
                }*/

                CoroutineScope(Dispatchers.Main).launch {
                    var results = getInnerJoinResult()
                    println(" results  ---->  ${results.size}")
                    for (res in results){
                        println("result ---->  ${res.empId}   ${res.name}   ${res.dept}")
                    }
                }
                //viewModel.deleteAllWords()
                //userViewModel.deleteAllUser()
            }

        }
    }
}
