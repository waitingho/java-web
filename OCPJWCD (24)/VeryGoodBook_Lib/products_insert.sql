/*
DROP TABLE IF EXISTS `vgb`.`book_details`;
DROP TABLE IF EXISTS `vgb`.`products`;

CREATE TABLE  `vgb`.`products` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `unit_price` double NOT NULL,
  `stock` int(10) unsigned NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `photo_url` varchar(200) DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'Product',
  `discount` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE  `vgb`.`book_details` (
  `product_id` int(10) unsigned NOT NULL,
  `authors` varchar(200) NOT NULL DEFAULT '',
  `publish_date` date NOT NULL,
  `publisher_id` int(10) unsigned NOT NULL,
  `language` varchar(45) NOT NULL DEFAULT '繁體中文',
  `isbn` char(13) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FK_book_details_to_publishers` (`publisher_id`),
  CONSTRAINT `FK_book_details_to_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  CONSTRAINT `FK_book_details_to_publishers` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/


INSERT INTO publishers (id,name) VALUES 
 (1,'悅知文化'),
 (2,'旗標科技'),
 (3,'博碩文化'),
 (4,'碁峰資訊'),
 (5,'歐萊禮');

INSERT INTO products (id,name,unit_price,stock,description,photo_url,type,discount) VALUES 
 (1,'Microsoft® SQL Server® 2016管理實戰',699,10,'完整涵蓋SQL Server 2016及其向下相容版本之管理技巧。從DBA觀點出發，建立正確的資料庫系統觀念。最實用的企業級資料庫管理與維護指南，解決常見的技術瓶頸。','http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/074/14/0010741473.jpg&v=58760962&w=348&h=348','Outlet',21),
 (2,'笑談軟體工程-例外處理設計的逆襲',580,10,'這世界上，大部分軟體開發「大師」都只教你如何設計「軟體的光明面」, 卻很少人願意告訴你如何解決「軟體的黑暗面」。但很遺憾的，軟體的異常狀態（黑暗面）不會比正常狀態（光明面）少，是你該把「例外處理」當成一回事兒的時候了。','http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/063/75/0010637503.jpg&v=537dd241&w=348&h=348','Outlet',10),
 (3,'JavaScript & JQuery 網站互動設計程式進化之道',780,10,'用更快更好的方式了解JavaScript和JQuery, 用完全不同的排版及說明方式完全顛覆你對電腦書的刻版印象','http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/074/47/0010744702.jpg&v=58a42dc7&w=348&h=348','Outlet',21),
 (4,'平底鍋料理100 與你共享的日常況味',380,10,'擁有15萬粉絲的「廚房旅行日記」粉絲頁共同主持人Joyce，為台灣人量身打造最在地化的平底鍋食譜！<br>新型態質感生活食譜<br>豐盛鐵鍋料理X YOUTUBE示範頻道 X 食材採買提案','http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/075/13/0010751397.jpg&v=58ff2552&w=348&h=348','Outlet',10),
 (5,'在咖啡冷掉之前-コーヒーが冷めないうちに',360,10,'讀者大讚「哭了四次」！如果能回到那一天，你最想見到誰？<br>★ 2017年本屋大賞TOP 10<br>★ 日本2016書籍年度總榜TOP20、文學榜TOP6<br>★ 不到一年銷量突破35萬本<br>★ 全球已售出6國版權，持續增加中。','http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/075/11/0010751153.jpg&v=58fdd3cb&w=348&h=348','Outlet',21),
 (6,'家事法官沒告訴你的事-親緣，以愛為名的試煉',350,10,'關於家事的糾結，最不該錯過、最專業、兼具情理法的感性剖析！<br>一輩子毫無法律問題需要解決的機率，有多高？<br>贏了官司，就是真的贏了嗎？<br>曾經緊密的關係，在出現裂痕時，才更顯痛楚。','http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/075/12/0010751290.jpg&v=58ff2534&w=348&h=348','Outlet',21),
 (7,'Information Architecture 100-100個網站規劃必備的知識',480,10,'無論是商業網站、企業網站、服務網站、社群網站…等，架構的擬定與藍圖的規劃都是必經過程。','http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/061/88/0010618801.jpg&v=5295cb0b&w=348&h=348','Outlet',21),
 (8,'奇幻夢境',299,10,'★ 暢銷插畫家Amily最新著色創作書','http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/001/067/10/0010671061.jpg&w=348&h=348&v=552e2196','Outlet',10),
 (51,'Quasi Water Brush 水溶性色鉛筆/粉彩筆專用 水筆 長版/大中小 3支組',150,10,'★美國知名設計品牌 Quasi 專業美術前衛設計,<br>★集水式筆管、不沾墨色筆刷，清洗簡單使用方便<br>★適合水溶性色鉛筆、粉蠟筆、粉彩筆、水彩原料使用<br>★大(5mm筆頭)、中(3mm筆頭)、小(2mm筆頭)  1組3支','http://im2.book.com.tw/image/getImage?i=http://www.books.com.tw/img/N00/078/74/N000787427.jpg&v=58bd0081&w=348&h=348','Product',0),
 (0,'STABILO 德國天鵝牌 aquacolor系列 水溶性色鉛筆36色',780,10,'亮麗的色彩顏色，高品質的筆蕊，在繪圖中不易斷裂，讓上色、混色過程更加簡易','http://im1.book.com.tw/image/getImage?i=http://www.books.com.tw/img/N00/049/78/N000497888.jpg&w=348&h=348&v=53c89bc2','Product',0);

INSERT INTO book_details (product_id,authors,publisher_id,publish_date,isbn) VALUES 
 (1,'胡百敬, 洪玉茹, 姚巧玫, 周妙謙',1,'2017-01-16','9789869423922'),
 (2,'陳建村(Teddy Chen)',1,'2014-05-20','9789865740382'),
 (3,'Jon Duckett',4,'2017-02-24','9789863478164'),
 (4,'鄭凱華(Joyce)',1,'2017-02-24','9789869462587'),
 (5,'川口俊和',1,'2017-05-01','9789869462518'),
 (6,'楊晴翔',1,'2017-04-28','9789869423977'),
 (7,'長谷川敦士',1,'2013-11-29','9789865912918'),
 (8,'Amily',1,'2015-04-20','9789865912697');
