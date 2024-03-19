//Felipe Morilho de Castro
package com.acelerazg

import com.acelerazg.view.SystemView

SystemView systemView = new SystemView()

while (true) {

    String option = systemView.showMenu()

    systemView.selectMenu(option)

}
