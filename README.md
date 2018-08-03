"# IntercepterTest" 


[SpringBoot2.x] Interceptor 안에 발생한 Exception, ControllerAdvice 로 관리하기.

> react + springboot 로 개발하던 중, axios 를 이용해 호출하는데 인터셉터에서 에러가 있어 Exception을 던졌는데, Advice에서 캐치가 안되었다. 그래서 테스트를 해보니 조건부로 되었는데 아직 확실히는 못찾았다. 아마 CORS 때문에 그런것 같은데 확실한건 아니다.


**현재까지 증상**
- postman 등 이용해 호출 => ControllerAdvice 에 캐치 가능
- react에 axios 호출 => ControllerAdvice에 캐치가 안됨.
