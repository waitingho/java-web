/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Administrator
 * Created: 2018/2/8
 */
DROP DATABASE IF EXISTS `vgb`;
CREATE DATABASE `vgb` DEFAULT CHARSET=utf8; /*!40100 DEFAULT CHARACTER SET utf8 */;
USE vgb;



DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` char(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `gender` char(1) NOT NULL,
  `email` varchar(60) NOT NULL,
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL DEFAULT '',
  `phone` varchar(20) DEFAULT NULL,
  `married` tinyint(1) NOT NULL DEFAULT '0',
  `blood_type` varchar(2) DEFAULT NULL,
  `discount` INT(5) NOT NULL DEFAULT 0,
  `type` varchar(20) NOT NULL DEFAULT 'Customer',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_unique_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO customers 
    (name,password,gender,email,birthday,id)
VALUES('安安','123456','M','fff@fff.fff.ff','1990-10-5','A123456789');

INSERT INTO customers 
    (id,name,password,gender,email,birthday,address,phone,married,blood_type,discount,type)
VALUES('A223456781','恩恩','123456','F','mmm@mmm.mmm.mm','1991-10-5','台北市復興北路66號6樓','02-25666554',1,'AB',20,'VIP');


DROP TABLE IF EXISTS `vgb`.`products`;
CREATE TABLE  `vgb`.`products` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  `unit_price` double NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `photo_url` varchar(200) NOT NULL,
  `photo_url2` varchar(200) DEFAULT NULL,
  `photo_url3` varchar(200) DEFAULT NULL,
  `photo_url4` varchar(200) DEFAULT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'product',
  `discount` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO products (id,name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,type,discount) VALUES 
(1,'聖誕老公公禮物盒',899,'今年的聖誕你必須要提早準備好新款的禮物盒又登場囉這是專門為了聖誕季節量身打造現在買回去貼照片就可以讓你心愛的他在聖誕節可以拿到噢','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a72fdc011ed0043bc/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a1cacaf1732000c77/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a59d524172f000030/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0b59d524171d00000d/800x.webp?source_format=jpg','product',21),
(2,'甜蜜小屋手作機關禮物盒',850,'【甜滋滋的浪漫小屋】這是一個屬於我們的小家，謝謝有妳的每一天！','https://shoplineimg.com/559785a6e37ec6046a000017/59489f929f9a4fb94b003b77/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f59563017280004eb/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f5956301737000455/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f6ef2d4d936004576/800x.webp?source_format=jpg','product',21),
(3,'小情人禮物盒',1200,'你心中的那位小情人是誰呢?不管是好朋友小朋友男朋友女朋友都可以是小情人唷><','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aaf72fdc05a350008de/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aa859d524675c000a9e/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aa959d524679c000a2b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aaf9f9a4f1437000998/800x.webp?source_format=jpg','product',21),
(4,'回憶小屋機關手作卡',999,'我們的回憶小屋這是我們倆的夢想家','https://shoplineimg.com/559785a6e37ec6046a000017/59a8dafe59d5241f86000300/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59a8d6e29f9a4f2d4d0046e9/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59a8d6e159d5241fb4000237/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59a8d6e16ef2d45756005866/800x.webp?source_format=jpg','Outlet',21),
(5,'法鬥狗屋禮物盒',1500,'法鬥一臉懵盯得你心癢癢比狗頭包更時尚、心意更足質感黑而帶點萌感用間狗屋讓他住進你心裡吧','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c5910abb9691800000d/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c590e64fe7ea6000036/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c5959d524ae9500000c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c589a76f0e6fa00000c/800x.webp?source_format=jpg','product',21),
(6,'貓咪小窩禮物盒',1500,'萌萌甜蜜小貓屋粉紅馬卡龍色系在你的心上撒嬌跟你住一起好嗎','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773410abb90734004767/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773659d52418d5000bb1/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773c9a76f018be00062b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773d00fdde18bf004807/800x.webp?source_format=jpg','product',21),
(7,'超精緻情人蛋糕浪漫禮物盒',1999,'今年情人節還不知道送對方什麼嗎？限量情人節浪漫手作奶油蛋糕禮物爆炸卡','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac0617069111bd81400/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac0617069111f150600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac2617069680fd47600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac261706958eafba700/800x.webp?source_format=jpg','product',21),
(8,'有你就幸福 情人禮物盒',1390,'幸福不需要什麼承諾不需要天長地久不需要朝夕相伴只要我心中有你你心中有我','https://shoplineimg.com/559785a6e37ec6046a000017/588dc89959d524170e000710/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/588dc8999f9a4f027600e391/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/588dc8999f9a4f025200e1be/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/588dc89972fdc0fc33012b3c/800x.webp?source_format=jpg','product',21),
(9,'手作驚喜禮物盒',1490,'可愛的配色，充滿愛的泡泡，一直很想送一個禮物盒給最愛的他/她，可是好複雜不知道怎麼開始。','https://s7.postimg.org/4dyjyacwr/IMG_8663_Copy.jpg','https://s7.postimg.org/yjwyd2jtn/IMG_8673_Copy.jpg','https://s1.postimg.org/u42573kxb/image.jpg','https://s7.postimg.org/dlvdsq9cr/IMG_8940_Copy.jpg','product',21),




(21,'偶像ＫＩＳＳ滑塊卡',599,'風靡好一陣子的韓劇超人氣夫婦卡片超甜蜜親親ＫＩＳＳ卡片全部由設計是純手工製作唷','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0ef7900fdde8d63000722/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0ef794e22a660ab000834/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0ef789a76f04d1d000728/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f5779a76f04d2b0007bd/800x.webp?source_format=jpg','product',21),
(22,'立體相機手工書',630,'拍下回憶的瞬間把此刻的美好收藏起來','https://shoplineimg.com/559785a6e37ec6046a000017/5a6800645521150a22001e67/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a68006b9f9a4f144a001de5/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a68006859d52418c1000312/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6800695521150a7d001cfc/800x.webp?source_format=jpg','Outlet',21),
(23,'親親驚喜手作抽拉卡',780,'計師純手工設計為情人節特別設計款也適合送給閨蜜唷商品少量現貨供應中！','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b25521156aae000b21/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b1080f0652fe000a43/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b39f9a4ffbf5000915/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b572fdc0b0df0009f9/800x.webp?source_format=jpg','product',21),
(24,'偶像彈跳驚喜卡',699,'風靡好一陣子的韓劇超人氣夫婦卡片超甜蜜親親ＫＩＳＳ卡片全部由設計是純手工製作唷','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f1560e64fed3ff000785/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f15610abb989f30007fc/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f1569a76f04cf0000861/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f15610abb98a09000863/800x.webp?source_format=jpg','product',21),
(25,'籃球手作卡片',799,'萬眾期待！籃球卡片來啦~送籃球控這款準沒錯~','https://shoplineimg.com/559785a6e37ec6046a000017/58cf677959d5241733000a72/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cf677559d524173f000944/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cf677559d5241748000a9e/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cf6776d4e395a183001c34/800x.webp?source_format=jpg','product',21);


