CREATE DATABASE IF NOT EXISTS ONESHOT DEFAULT CHARACTER SET utf8mb4;

USE ONESHOT;

CREATE TABLE IF NOT EXISTS `user` ( -- 유저 정보를 저장하는 테이블
  `user_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '유저 기본 PK',
  `email` VARCHAR(255) NOT NULL UNIQUE COMMENT '유저 id 역할을 하는 email',
  `password` VARCHAR(255) NOT NULL COMMENT '비밀번호',
  `nickname` VARCHAR(255) NOT NULL COMMENT '서비스 상 노출 될 닉네임',
  `admin` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '관리자 여부 : 0 일반유저 | 1 관리자',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '유저 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 유저 row 수정 시각'
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO user
(email, password, nickname, admin)
VALUES
("ssafy@ssafy.com", "0000", "비회원", 0),
("junghoon1039@gmail.com", "000123", "관리자", 1),
("kim@ssafy.com", "1234", "김싸피", 0)
;

CREATE TABLE IF NOT EXISTS `brand` ( -- 브랜드 정보를 저장하는 테이블
  `brand_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '브랜드 기본 PK',
  `brand_name` VARCHAR(255) NOT NULL UNIQUE COMMENT '브랜드 이름',
  `logo` VARCHAR(255) NOT NULL COMMENT '브랜드 로고',
  `brand_url` VARCHAR(255) COMMENT '브랜드 공식 홈페이지 url',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '서비스 여부 : 0 서비스 안함 | 1 서비스 함',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '브랜드 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 브랜드 row 수정 시각'
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `menu` ( -- 메뉴 정보를 저장하는 테이블 | 브랜드에 귀속
  `menu_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '메뉴 기본 PK',
  `brand_id` INT NOT NULL COMMENT '메뉴가 속한 브랜드의 id',
  `menu_name` VARCHAR(255) NOT NULL COMMENT '메뉴 이름',
  `img` VARCHAR(255) NOT NULL COMMENT '메뉴 이미지',
  `type`  VARCHAR(255) NOT NULL COMMENT '메뉴 종류',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '메뉴 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 메뉴 row 수정 시각',
  UNIQUE KEY (`brand_id`, `menu_name`),
  CONSTRAINT `fk_menu_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`) -- 브랜드id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `menu_detail` ( -- 메뉴 상세 정보를 저장하는 테이블 | 메뉴에 귀속
  `menu_detail_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '메뉴상세 기본 PK',
  `menu_id` INT NOT NULL COMMENT '메뉴 상세가 속한 메뉴의 id',
  `price` INT NOT NULL COMMENT '해당 메뉴의 가격',
  `size` ENUM ('S', 'M', 'L') NOT NULL DEFAULT 'M' COMMENT '사이즈 : Small | Medium | Large',
  `size_name` VARCHAR(255) NOT NULL COMMENT '메뉴 사이즈의 브랜드 별 이름',
  `temperature` ENUM ('ICE', 'HOT', 'ELSE') NOT NULL COMMENT '음료 온도 : ICE : 차가운 음료 | HOT : 뜨거운 음료 | ELSE : 기타',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '메뉴상세 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 메뉴상세 row 수정 시각',
  UNIQUE KEY (`menu_id`, `size`, `temperature`),
  CONSTRAINT `fk_menu_detail_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) -- 메뉴id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `order` ( -- 개별 주문의 종합 결과 주문서 정보 테이블 | 유저에게 귀속
  `order_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '주문서 기본 PK',
  `user_id` INT NOT NULL COMMENT '주문서 생성 유저 | 비회원일 경우 고정값을 가짐',
  `brand_id` INT NOT NULL COMMENT '주문하는 브랜드 id',
  `order_code` VARCHAR(255) NOT NULL UNIQUE COMMENT '주문서 공유 url',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '주문서 서비스 종료 여부 : 0 종료 안됨 | 1 종료됨',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문서 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문서 row 수정 시각',
  CONSTRAINT `fk_order_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`), -- 유저id 외래키
  CONSTRAINT `fk_order_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`) -- 브랜드id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `order_detail` ( -- 개별 주문 정보 테이블 | 주문서에 귀속
  `order_detail_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '주문 기본 PK',
  `order_id` INT NOT NULL COMMENT '주문이 속한 주문서의 id',
  `menu_detail_id` INT NOT NULL COMMENT '주문에 해당하는 메뉴상세 의 id',
  `name` VARCHAR(255) NOT NULL COMMENT '주문을 실시한 사용자 이름',
  `amount` INT NOT NULL DEFAULT 1 COMMENT '주문 내역에 속한 메뉴의 개수',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문 row 수정 시각',
  CONSTRAINT `fk_orderdetail_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`), -- 주문서id 외래키
  CONSTRAINT `fk_orderdetail_menudetail_id` FOREIGN KEY (`menu_detail_id`) REFERENCES `menu_detail` (`menu_detail_id`) -- 메뉴id 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

commit;

SELECT * FROM user;