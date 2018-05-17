定制api请求。但是依然要明确填上url，否则，spring注册时候会认为路径重复报错。

只是多了种访问方式：

- GET、PUT、DELETE： 


    http://localhost:8080/api.do?action=testController.testGet2
    
    http://localhost:8080/api.do?action=apiTestController.apiTestGet&name=zmt&&i=3&bd=3.22&&f=3.8&&d=9.33&&b=1

- POST： 
 
 
    http://localhost:8080/api.do
    
    body：每个{}对应一个vo
    
    {
      "action": "apiTestController.apiTestPost1",
      "token": "rt_1526477534814",
      "args": [
        {
          "first": 0,
          "rows": 10,
          "sortOrder": 1,
          "filters": {},
          "globalFilter": null
        },
        {
          "taskType": "All",
          "taskStatus": "All",
          "matchType": "All",
          "queryDateType": "bill",
          "checkType": "All",
          "msfCheck": "All",
          "clientIsVip": "All",
          "beginDate": "2018-02-13 00:00:00",
          "endDate": "2018-05-16 23:59:59"
        }
      ]
    }
    