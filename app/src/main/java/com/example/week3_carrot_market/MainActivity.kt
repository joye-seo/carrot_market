package com.example.week3_carrot_market

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.week3_carrot_market.databinding.ActivityMainBinding
import com.example.week_1.Fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var aroundFragment: AroundFragment

    private lateinit var chatFragment: ChatFragment

    private lateinit var homeFragment: HomeFragment

    private lateinit var profileFragment: ProfileFragment

    private lateinit var townFragment: TownFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigationBar()
        bottomNavOption()
        clickEvent()

    }

    private fun bottomNavOption() = with(binding.bottomNav) {

        // 바텀네비게이션 아이콘 기본색 적용
        itemIconTintList = null

        // 클릭 시 ripple 없애기
        itemRippleColor = null

    }

    private fun initNavigationBar() {

        aroundFragment = AroundFragment()
        chatFragment = ChatFragment()
        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()
        townFragment = TownFragment()


        binding.bottomNav.run {
            setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.bottom_around -> changeFragment(aroundFragment)
                    R.id.bottom_chat -> changeFragment(chatFragment)
                    R.id.bottom_home -> changeFragment(homeFragment)
                    R.id.bottom_profile -> changeFragment(profileFragment)
                    R.id.bottom_town -> changeFragment(townFragment)
                }
                true
            }
            // 초기 프레그먼트 값 세팅!
            selectedItemId = R.id.bottom_home
        }

    }

    private fun clickEvent(){
        binding.fabWrite.setOnClickListener {
            val intent = Intent(this,WriteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragment.id, fragment)
            .commit()
    }


}