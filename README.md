# ms-accounts
###Se construye el primer microservicio del curso, el de cuentas, que se denomina ms-accounts.

##Pasos siguiendo la estrategía TDD (Test Driven Development)

<ol>
<li>DTOs a utilizar como parámetros y retorno en el Service.</li>
<ul>
<li>AccountBalanceDto</li>
<li>AccountsBalanceDto</li>
</ul>
<li>Interfaz de Service.</li>
<ul>
<li>AccountService</li>
</ul>
<li>Entidades de acceso a datos.</li>
<ul>
<li>TransactionModel</li>
<li>AccountModel</li>
<li>TransactionType</li>
</ul>
<li>Interfaz de Repository.</li>
<ul>
<li>AccountRepository</li>
</ul>
<li>Excepciones específicas.</li>
<ul>
<li>BusinessException</li>
<li>NotFoundException</li>
<li>BadRequestException</li>
</ul>
<li>Implementación vacía de Service.</li>
<ul>
<li>AccountServiceImpl</li>
</ul>
<li>Test unitario de Service, donde se define la lógica a través de los test.</li> 
<ul>
<li>AccountServiceMockTest</li>
</ul>
<li>Implementación de Service, verificando funcionamiento de los test.</li>
<ul>
<li>XXXX</li>
</ul>
<li>Implementación dummy de Repository (en capítulos posteriores se construye implementación real).</li> 
<ul>
<li>XXXX</li>
</ul>
<li>Test integrado de Service.</li>
<ul>
<li>AccountServiceIntegTest</li>
</ul>
<li>Controller que publica Service (en el punto siguiente).</li> 
<ul>
<li>XXXX</li>
</ul>
</ol>
