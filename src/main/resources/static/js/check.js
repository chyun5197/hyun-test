// // 토큰 확인용
// const createButton = document.getElementById("create-btn");
//
// if (createButton){
//     createButton.addEventListener("click", (event) => {
//         body = JSON.stringify({
//
//         });
//         function success(){
//             alert('토큰 전송 완료되었습니다.');
//             location.replace("/api/is-logout");
//         }
//         function fail(){
//             alert('토큰 전송 실패했습니다.');
//             location.replace("/api/is-logout");
//         }
//         httpRequest("POST", "/checker", body, success, fail);
//     })
// }
//
// // 쿠키를 가져오는 함수
// function getCookie(key){
//     var result = null;
//     var cookie = document.cookie.split(";");
//     cookie.some(function(item){
//         item = item.replace(" ", "");
//         var dic = item.split("=");
//         if (key === dic[0]){
//             result = dic[1];
//             return true;
//         }
//     });
//     return result;
// }
//
// // 토큰 확인해서 권한 있을때만 등록 가능하게 체크
// function httpRequest(method, url, body, success, fail){
//     fetch(url, {
//         method: method,
//         headers:{
//             // 로컬 스토리지에서 액세스 토큰 값을 가져와 헤더에 추가
//             Authorization: "Bearer" + localStorage.getItem("access_token"),
//             "Content-Type": "application/json"
//         },
//         body: body
//     }).then((response) => {
//         if (response.status === 200 || response.status === 201){
//             return success();
//         }
//         const refresh_token = getCookie("refresh_token");
//         if (response.status === 401 && refresh_token){
//             fetch("/api/token", {
//                 method: "POST",
//                 headers: {
//                     Authorization: "Bearer" + localStorage.getItem("access_token"),
//                     "Content-Type": "application/json"
//                 },
//                 body: JSON.stringify({
//                     refreshToken: getCookie("refresh_token")
//                 }),
//             })
//                 .then((res) => {
//                     if (res.ok){
//                         return res.json();
//                     }
//                 })
//                 .then((result) => {
//                     // 재발급이 성공하면 로컬 스토리지 값을 새로운 액세스 토큰으로 교체
//                     localStorage.setItem("access_token", result.accessToken);
//                     httpRequest(method, url, body, success, fail);
//                 }).catch((error) => fail());
//         }else{
//             return fail();
//         }
//     });
// }
//
//
// // 로그아웃 기능
// const logoutButton = document.getElementById('logout-btn');
//
// if (logoutButton) {
//     logoutButton.addEventListener('click', event => {
//         function success() {
//             // 로컬 스토리지에 저장된 액세스 토큰을 삭제
//             localStorage.removeItem('access_token');
//
//             // 쿠키에 저장된 리프레시 토큰을 삭제
//             deleteCookie('refresh_token');
//             location.replace('/login');
//         }
//         function fail() {
//             alert('로그아웃 실패했습니다.');
//         }
//
//         httpRequest('DELETE','/api/refresh-token', null, success, fail);
//     });
// }
//
//
// // 쿠키를 삭제하는 함수
// function deleteCookie(name) {
//     document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
// }