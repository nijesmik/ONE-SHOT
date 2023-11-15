CREATE DATABASE IF NOT EXISTS ONESHOT DEFAULT CHARACTER SET utf8mb4;

USE ONESHOT;

CREATE TABLE IF NOT EXISTS `user` ( -- 유저 정보를 저장하는 테이블
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '유저 기본 PK',
  `user_email` VARCHAR(256) NOT NULL UNIQUE COMMENT '유저 id 역할을 하는 email',
  `password` VARCHAR(256) NOT NULL COMMENT '비밀번호',
  `nick_name` VARCHAR(256) NOT NULL COMMENT '서비스 상 노출 될 닉네임',
  `admin` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '관리자 여부 : 0 일반유저 | 1 관리자',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '유저 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 유저 row 수정 시각'
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO user
(user_email, password, nick_name, admin)
VALUES
("ssafy@ssafy.com", "0000", "비회원", 0),
("junghoon1039@gmail.com", "000123", "관리자", 1),
("kim@ssafy.com", "1234", "김싸피", 0)
;

CREATE TABLE IF NOT EXISTS `brand` ( -- 브랜드 정보를 저장하는 테이블
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '브랜드 기본 PK',
  `brand_name` VARCHAR(256) NOT NULL COMMENT '브랜드 이름',
  `brand_url` VARCHAR(256) COMMENT '브랜드 공식 홈페이지 url',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '브랜드 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 브랜드 row 수정 시각'
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO brand
(brand_name, brand_url)
VALUES
("스타벅스", "https://www.starbucks.co.kr"),
("메머드커피", "https://www.mmthcoffee.com/")
;

CREATE TABLE IF NOT EXISTS `menu` ( -- 메뉴 정보를 저장하는 테이블 | 브랜드에 귀속
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '메뉴 기본 PK',
  `menu_code` VARCHAR(256) NOT NULL COMMENT '메뉴 번호',
  `brand_id` INT NOT NULL COMMENT '메뉴가 속한 브랜드의 id',
  `menu_name` VARCHAR(256) NOT NULL COMMENT '메뉴 이름',
  `price` INT NOT NULL COMMENT '메뉴 가격',
  `size` VARCHAR(256) NOT NULL COMMENT '메뉴 사이즈',
  `type` ENUM ('COLD', 'HOT', 'ELSE') NOT NULL COMMENT '메뉴 타입 : COLD : 차가운 음료 | HOT : 뜨거운 음료 | ELSE : 기타',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '메뉴 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 메뉴 row 수정 시각',
  UNIQUE KEY (`menu_code`, `brand_id`), -- 브랜드id, 메뉴코드 복합 유니크 | 브랜드가 다른경우 동일 메뉴코드 가능
  CONSTRAINT `fk_menu_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`) -- 브랜드id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO menu
(menu_code, brand_id, menu_name, price, size, type)
VALUES
("star0001", "1", "아이스 카페 아메리카노", "3000", "tall 355ml", "COLD"),
("star0002", "1", "아이스 카페 아메리카노", "3500", "grande 472ml", "COLD"),
("star0003", "1", "카페 아메리카노", "3500", "grande 472ml", "HOT"),
("star0004", "1", "카페라떼", "4000", "grande 472ml", "HOT"),
("mmtc0001", "2", "아메리카노", "1600", "M 20oz", "COLD")
;

CREATE TABLE IF NOT EXISTS `order` ( -- 개별 주문의 종합 결과 주문서 정보 테이블 | 유저에게 귀속
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '주문서 기본 PK',
  `user_id` INT NOT NULL COMMENT '주문서 생성 유저 | 비회원일 경우 고정값을 가짐',
  `order_url` VARCHAR(256) NOT NULL COMMENT '주문서 공유 url',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '주문서 서비스 노출 여부 : 0 노출 | 1 노출 안함',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문서 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문서 row 수정 시각',
  CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) -- 유저id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `order_detail` ( -- 개별 주문 정보 테이블 | 주문서에 귀속
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '주문 기본 PK',
  `order_id` INT NOT NULL COMMENT '주문이 속한 주문서의 id',
  `menu_id` INT NOT NULL COMMENT '주문에 해당하는 메뉴의 id',
  `order_user` VARCHAR(256) NOT NULL COMMENT '주문을 실시한 사용자 이름',
  `amount` INT NOT NULL DEFAULT 1 COMMENT '주문 내역에 속한 메뉴의 개수',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문 row 수정 시각',
  CONSTRAINT `fk_detail_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`), -- 주문서id 외래키
  CONSTRAINT `fk_detail_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) -- 메뉴id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

commit;

SELECT * FROM user;