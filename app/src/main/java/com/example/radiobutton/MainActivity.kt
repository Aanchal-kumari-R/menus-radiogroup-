package com.example.radiobutton

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.PopupMenu
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener,
    CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityMainBinding
    val list: ArrayList<String> = ArrayList()
     var rgroup:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSelect.setOnClickListener(this)
        binding.rgroup.setOnCheckedChangeListener(this)
        binding.chApple.setOnCheckedChangeListener(this)
        binding.chGuava.setOnCheckedChangeListener(this)
        binding.chGrapes.setOnCheckedChangeListener(this)
        binding.chLitchi.setOnCheckedChangeListener(this)

        registerForContextMenu(binding.btnSelect)
    }


    override fun onCheckedChanged(checked: RadioGroup?, p1: Int) {
        when (checked?.checkedRadioButtonId) {

            R.id.red -> {
                rgroup=(binding.red.text.toString())
                Toast.makeText(this, "Your favourate color is red", Toast.LENGTH_LONG).show()
            }
            R.id.yellow -> {
                rgroup=(binding.yellow.text.toString())
                Toast.makeText(this, "Your favourate color is yellow", Toast.LENGTH_LONG).show()
            }
            R.id.green -> {
                rgroup=(binding.green.text.toString())
                Toast.makeText(this, "Your favourate color is green", Toast.LENGTH_LONG).show()
            }
            R.id.pink -> {
                rgroup=(binding.pink.text.toString())
                Toast.makeText(this, "Your favourate color is pink", Toast.LENGTH_LONG).show()
            }
            R.id.orange -> {
                rgroup=(binding.orange.text.toString())
                Toast.makeText(this, "your favourate color is orange", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onClick(view: View?) {

        val popupMenu = PopupMenu(this,view)
        menuInflater.inflate(R.menu.popup_menu,popupMenu.menu)
        popupMenu.show()
        popupMenu.setOnMenuItemClickListener(object :PopupMenu.OnMenuItemClickListener{
            override fun onMenuItemClick(p0: MenuItem?): Boolean {
          return true
            }

        })
        binding.textview01.text = rgroup
        binding.textview02.text = list.toString()
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when (buttonView?.id) {
            R.id.ch_apple -> {
                if (binding.chApple.isChecked) {
                    list.add(binding.chApple.text.toString())
                } else {
                    list.remove(binding.chApple.text.toString())
                }
            }
            R.id.ch_guava -> {
                if (binding.chGuava.isChecked) {
                    list.add(binding.chGuava.text.toString())
                } else {
                    list.remove(binding.chGuava.text.toString())
                }

            }
            R.id.ch_grapes -> {
                if (binding.chGrapes.isChecked) {
                    list.add(binding.chGrapes.text.toString())
                } else {
                    list.remove(binding.chGrapes.text.toString())
                }
            }
            R.id.ch_litchi -> {
                if (binding.chLitchi.isChecked) {
                    list.add(binding.chLitchi.text.toString())
                } else {
                    list.remove(binding.chLitchi.text.toString())
                }
            }


        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.contact_us1 -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

            }
            R.id.call_4 -> {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
                ) {
                    val intent = Intent(Intent.ACTION_CALL)
                    intent.data = Uri.parse("tel:7899898090")
                    startActivity(intent)
                } else {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.CALL_PHONE),
                        1001
                    )
                }

            }
            R.id.dial_5 -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:66787989890"))
                startActivity(intent)

            }
            R.id.action_6 -> {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://developer.android.com/reference/android/webkit/WebView")
                )
                startActivity(intent)
            }
            R.id.aboutdev_7 -> {
                val intent = Intent(this, AboutDeveloper::class.java)
                startActivity(intent)
                return true

            }

            R.id.share_2 -> {
                Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
            }
            R.id.exit_3 -> {
                finish();
                System.exit(0)

            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }
    }









