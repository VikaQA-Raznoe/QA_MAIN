Selenoid Home Work(после урока 26)
=====================
Подготовка
-----------------------------------
* Для запуска тестов используется RemoteWebDriver, который нужен для работы с Selenoid
* Для наглядности в оба проекта были добавлены фиктивные тесты

Для запуска тестов в многопоточном режиме я использовала:
***
1)testng.xml в приложении ExampleWithTestNGMultiThread
***
Пример запуска теста не в многопоточном режиме - ExampleFromDigitalOcean
***

Selenoid
=====================
Для выполнения задания было решено использовать Linux. Для этого:
***
* был установлен VirtualBox
* была создана виртуальная машина
* на виртуальную машину была установлена последняя стабильная версия Ubuntu
* был установлен Docker
* был устновлен на Docker - Selenoid
***
Установка Docker на Linux
-----------------------------------
***
Установка Docker на Linux не вызвала никаких проблем. Инсталяция производилась согласно руководству: 
<https://docs.docker.com/install/linux/docker-ce/ubuntu/>

Вот основные шаги:
***
Шаг первый:
***
![Шаг первый:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallDocker-1.png)
Шаг второй:
***
![Шаг второй:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallDocker-2.png)
***
Шаг третий:
***
![Шаг третий:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallDocker-3.png)
***

Установка Selenoid на Linux
-----------------------------------
***
Шаг первый:
***
![Шаг первый:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallSelenoid-1.png)
***
Шаг второй:
***
![Шаг второй:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallSelenoid-2.png)
***
Шаг третий:
***
![Шаг третий:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallSelenoid-3.png)
***
Шаг четвертый:
***
![Шаг четвертый:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/InstallSelenoid-4.png)
***
Проброс портов в VirtualBox
-----------------------------------
***
Для обращения к Selenoid из родительской ОС (Windows) пришлось "прокинуть порты" в настройках сети виртуальной машины. 
После чего можно было бы обратиться к Selenoid, расположенному в гостевой ОС(Ubuntu). 
Это необходимо т.к. на Windows ведётся разработка тестов.
***
* Порт 4444 используется в Linux для обращения к Selenoid-UI по адресу <http://127.0.0.1:4444/wd/hub>
* В настройках виртуальной машины, в разделе Сеть нужно выбрать Сетевой мост в пункте Тип подключения
* Сейчас порт 8080 в Windows используется для обращения Selenoid-UI по адресу: адрес виртульной машины/wd/hub
***
Запуск тестов в многопоточном режиме
-----------------------------------
Выполнение тестов в 3 потока на Selenoid:
* два теста + главный топок, в котором запускается приложение
***
![Три потока:](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/MultiThread.bmp)
***
VNC
-----------------------------------
***
Подключение по протоколу VNC к контейнеру и просмотр хода выполнения теста.
***
![экран VNC](https://github.com/VikaQA-Raznoe/QA_MAIN/blob/master/Selenoid%20Home%20Work(после%20урока%2026)/IMAGES/VNC.bmp)
***