CREATE DATABASE IF NOT EXISTS ONESHOT DEFAULT CHARACTER SET utf8mb4;

USE ONESHOT;

CREATE TABLE IF NOT EXISTS `user` ( -- 유저 정보를 저장하는 테이블
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '유저 기본 PK',
  `user_code` VARCHAR(256) NOT NULL UNIQUE KEY COMMENT '유저 고유 번호',
  `user_email` VARCHAR(256) NOT NULL COMMENT '유저 id 역할을 하는 email',
  `password` VARCHAR(256) NOT NULL COMMENT '비밀번호',
  `nick_name` VARCHAR(256) NOT NULL COMMENT '서비스 상 노출 될 닉네임',
  `admin` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '관리자 여부 : 0 일반유저 | 1 관리자',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '유저 서비스 노출 여부 : 0 노출 안함 | 1 노출',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '유저 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 유저 row 수정 시각'
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO user
(user_code, user_email, password, nick_name, admin, service)
VALUES
("000000", "ssafy@ssafy.com", "1234", "비회원", 0, 1),
("000001", "junghoon1039@gmail.com", "1234", "관리자-박정훈", 1, 1),
("000002", "sejin@gmail.com", "1234", "관리자-김세진", 1, 1)
;

CREATE TABLE IF NOT EXISTS `brand` ( -- 브랜드 정보를 저장하는 테이블
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '브랜드 기본 PK',
  `brand_code` VARCHAR(256) NOT NULL UNIQUE KEY COMMENT '브랜드 고유 번호',
  `brand_name` VARCHAR(256) NOT NULL COMMENT '브랜드 이름',
  `brand_url` VARCHAR(256) COMMENT '브랜드 공식 홈페이지 url',
  `crawling` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '브랜드 크롤링 여부 : 0 크롤링 안함 | 1 크롤링',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '브랜드 서비스 노출 여부 : 0 노출 안함 | 1 노출',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '브랜드 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 브랜드 row 수정 시각'
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `menu` ( -- 메뉴 정보를 저장하는 테이블 | 브랜드에 귀속
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '메뉴 기본 PK',
  `menu_code` VARCHAR(256) NOT NULL COMMENT '메뉴 고유 번호',
  `brand_code` VARCHAR(256) NOT NULL COMMENT '메뉴가 속한 브랜드의 고유 번호',
  `menu_name` VARCHAR(256) NOT NULL COMMENT '메뉴 이름',
  `price` INT NOT NULL COMMENT '메뉴 가격',
  `size` VARCHAR(256) COMMENT '메뉴 사이즈',
  `capacity` INT COMMENT '메뉴 용량',
  `calorie` INT COMMENT '메뉴 칼로리',
  `type` ENUM ('COLD', 'HOT', 'BOTH', 'ELSE') DEFAULT 'BOTH' COMMENT '메뉴 타입 : COLD : 차가운 음료만 가능 | HOT : 뜨거운 음료만 가능 | BOTH : 둘다 가능 | ELSE : 기타',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '메뉴 서비스 노출 여부 : 0 노출 안함 | 1 노출',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '메뉴 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 메뉴 row 수정 시각',
  UNIQUE KEY (`menu_code`, `brand_code`), -- 브랜드코드, 메뉴코드 복합 유니크 | 브랜드가 다른경우 동일 메뉴코드 가능
  CONSTRAINT `fk_menu_brand_code` FOREIGN KEY (`brand_code`) REFERENCES `brand` (`brand_code`) -- 브랜드코드 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `order` ( -- 개별 주문의 종합 결과 주문서 정보 테이블 | 유저에게 귀속
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '주문서 기본 PK',
  `order_code` VARCHAR(256) NOT NULL UNIQUE KEY COMMENT '주문서 고유 번호',
  `user_code` VARCHAR(256) NOT NULL COMMENT '주문서 생성 유저 | 비회원일 경우 고정값을 가짐',
  `order_url` VARCHAR(256) NOT NULL COMMENT '주문서 공유 url',
  `order_list` TEXT COMMENT '주문서에 속한 주문들의 정보 | JSON 배열 형태',
  `total_price` INT COMMENT '주문서 주문들의 총 금액 합',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '주문서 서비스 노출 여부 : 0 노출 안함 | 1 노출',
  `info` TEXT COMMENT '사용자가 기입한 주문서 특이 사항',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문서 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문서 row 수정 시각',
  CONSTRAINT `fk_order_user_code` FOREIGN KEY (`user_code`) REFERENCES `user` (`user_code`) -- 유저코드 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE IF NOT EXISTS `order_detail` ( -- 개별 주문 정보 테이블 | 결과서에 귀속
  `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '주문 기본 PK',
  `detail_code` VARCHAR(256) NOT NULL UNIQUE KEY COMMENT '주문 고유 번호',
  `order_code` VARCHAR(256) NOT NULL COMMENT '주문이 속한 결과서의 고유 번호',
  `menu_code` VARCHAR(256) NOT NULL COMMENT '주문에 해당하는 메뉴의 고유 번호',
  `order_user` VARCHAR(256) NOT NULL COMMENT '주문을 실시한 사용자 이름',
  `amount` INT NOT NULL DEFAULT 1 COMMENT '주문 내역에 속한 메뉴의 개수',
  `sum_price` INT NOT NULL COMMENT '주문 내역에 속한 메뉴의 가격 합',
  `service` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '주문 서비스 노출 여부 : 0 노출 안함 | 1 노출',
  `info` TEXT COMMENT '사용자가 기입한 주문 특이 사항',
  `created_time`  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '주문 row 생성 시각',
  `updated_time`  TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '마지막 주문 row 수정 시각',
  CONSTRAINT `fk_detail_order_code` FOREIGN KEY (`order_code`) REFERENCES `order` (`order_code`), -- 결과서코드 외래키
  CONSTRAINT `fk_detail_menu_code` FOREIGN KEY (`menu_code`) REFERENCES `menu` (`menu_code`) -- 메뉴코드 외래키
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

commit;

SELECT * FROM user;