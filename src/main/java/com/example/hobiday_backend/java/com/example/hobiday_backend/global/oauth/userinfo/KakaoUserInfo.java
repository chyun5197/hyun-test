package com.example.hobiday_backend.global.oauth.userinfo;//package com.example.hobiday_backend.global.oauth.userinfo;//package com.culture.config.kakao;
//
//import java.util.Map;
//
//public class KakaoUserInfo implements OAuth2UserInfo{
//    private String id;
//    private Map<String, Object> kakaoAccount;
//
//    public KakaoUserInfo(Map<String, Object> attributes, String id ) {
//        this.kakaoAccount = attributes;
//        this.id = id;
//    }
//
//    @Override
//    public String getEmail() {
//        return String.valueOf(kakaoAccount.get("email"));
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
//}



//        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//        System.out.println("authenication: "+ oAuth2User.getAttributes());
//        System.out.println("OAuth2User: " + oauth.getAttributes());
