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