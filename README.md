<a name="readme-top"></a>

<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="src/images/logo.png" alt="Logo" width="100" height="80">
  </a>

<h1 align="center">Mini test automation project</h1>

  <p align="center">Playwright+TestNG+Cucumber</p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

This is a small project to automate a test HRM site using Playwright, TestNG and BDD-framework Cucumber. The structure of the tests is built on the principles of the PageObjectPattern.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
* ![Playwright](https://img.shields.io/badge/Playwright-45ba4b?style=for-the-badge&logo=Playwright&logoColor=white)
* ![testng](https://img.shields.io/badge/-TestNG-090909?style=for-the-badge&color=red)
* ![cucumber](https://img.shields.io/badge/-Cucumber-090909?style=for-the-badge&color=green)
* ![maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)


<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* JVM 14+; to check java version run following cmd command:
  ```sh
  java -version
  ```
* Apache Maven 3.9.1+; to check java version run following cmd command:
  ```sh
  mvn -v
  ```

### Installation

#### Clone the repo
   ```sh
   git clone https://gitlab.nixdev.co/lukaniuk/playwright.git
   ```
 
 

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

* To run tests open the project dir and use following command
  ```sh
    mvn clean test
  ```
* Tests can be run on different browsers by changing the "BrowserType" value int the property file. Available values:
  ```
    BrowserType=Chrome
    BrowserType=Firefox
    BrowserType=Safari
  ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Telegram - [@from_names_import_smth](https://t.me/from_names_import_smth)

Project Link: [https://github.com/fromnameimport/playwright)

<p align="right">(<a href="#readme-top">back to top</a>)</p>