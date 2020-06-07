#
1.Создаем POJO объект, который будет использоваться для отправки сообщений:
   
    - model.HelloWorldMessage
2.Настройкa встроенного ActiveMQServer:

    - main
    
3. Настройка конфигурации исполнителя задач:


    -config.TaskConfig
4.Настраиваем конвертер сообщений с сообщениями JMS:

    - config.JSMConfig
5. установливаем компонент, который будет отправлять все сообщени:


    - config.JSMConfig -> даем имя очереди
    - sender.HelloSender
    
    


