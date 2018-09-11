Report-ui:

Installation 
1. Pull report-ui source files on the system
2. Install nodejs https://nodejs.org/en/download/
3. Open command prompt at source folder
4. Run command npm i
5. Run command npm run build
6. Run command npm start
7. Application is now accessible at http://localhost:8080/
Configure backend
8. Open report-ui/webpack.config.js 
9. Change process.env.API_URL to backend server url
plugins :[ new webpack.DefinePlugin({
      'process.env':{
        'API_URL': JSON.stringify('http://localhost:8090')
      }      
    })


Database configuration :

1. Install any version of mysql https://dev.mysql.com/downloads/installer/
2. Open mysql-workbench or work with mysql-command line client
3. Create database website-report
4. Import data from data.csv 	
Or run dataInsert.sql  	


Website-report server :

Installation 

5. Pull website-report/website-report folder on the system
6. Install and configure Java 8 or greater http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
7. Install and configure Maven https://maven.apache.org/download.cgi
8. Open websiteranking\src\main\resources\application.properties
9. If you wish to change the server port, update property 
server.port=8090
10. Configure database to work with
spring.datasource.url=jdbc:mysql://localhost:3306/website_report
spring.datasource.username=root
spring.datasource.password=<password that you entered on mysql installation>
11. Verify database name and password
12. Open command prompt and cd <project folder website-report/website-report>
13. run command mvn clean install
target folder will be generated.
14. cd target
       run as java application
java -jar websiteranking-1.0.0.jar

15. Application is up on http://localhost:8090/
16. View apis available at website-ranking by opening http://localhost:8090/swagger-ui.html	
17. Run api using curl or from browser
http://localhost:8090/websites?date=2018-09-11&limit=5&sortBy=MostVisits




