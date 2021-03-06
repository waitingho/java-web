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
    (id,name,password,gender,email,birthday,address,phone,married,blood_type,discount,type) VALUES
('A123456798','安安','123456','M','four.lee.tw@hotmail.com','2001-12-25','台北市復興北路99號12F','0987654321',0,'O',0,'Customer'),
('A223456781','恩恩','123456','F','mmm@mmm.mmm.mm','1991-10-5','台北市復興北路66號6樓','02-25666554',1,'AB',20,'VIP');


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
  `style` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL DEFAULT 'Product',
`stock` int(10) unsigned DEFAULT NULL,
  `discount` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO products (id,name,unit_price,description,photo_url,photo_url2,photo_url3,photo_url4,style,type,stock,discount) VALUES 
(1,'聖誕老公公禮物盒',899,'今年的聖誕你必須要提早準備好新款的禮物盒又登場囉這是專門為了聖誕季節量身打造現在買回去貼照片就可以讓你心愛的他在聖誕節可以拿到噢','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a72fdc011ed0043bc/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a1cacaf1732000c77/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0a59d524172f000030/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5859ff0b59d524171d00000d/800x.webp?source_format=jpg','house','Product',5,21),
(2,'甜蜜小屋手作機關禮物盒',850,'【甜滋滋的浪漫小屋】這是一個屬於我們的小家，謝謝有妳的每一天！','https://shoplineimg.com/559785a6e37ec6046a000017/59489f929f9a4fb94b003b77/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f59563017280004eb/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f5956301737000455/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59489f8f6ef2d4d936004576/800x.webp?source_format=jpg','house','Product',5,21),
(3,'小情人禮物盒',1200,'你心中的那位小情人是誰呢?不管是好朋友小朋友男朋友女朋友都可以是小情人唷><','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aaf72fdc05a350008de/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aa859d524675c000a9e/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aa959d524679c000a2b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a670aaf9f9a4f1437000998/800x.webp?source_format=jpg','house','Product',4,21),
(4,'回憶小屋機關手作卡',999,'我們的回憶小屋這是我們倆的夢想家','https://shoplineimg.com/559785a6e37ec6046a000017/59a8dafe59d5241f86000300/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59a8d6e29f9a4f2d4d0046e9/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59a8d6e159d5241fb4000237/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59a8d6e16ef2d45756005866/800x.webp?source_format=jpg','house','Outlet',5,10),
(5,'法鬥狗屋禮物盒',1500,'法鬥一臉懵盯得你心癢癢比狗頭包更時尚、心意更足質感黑而帶點萌感用間狗屋讓他住進你心裡吧','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c5910abb9691800000d/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c590e64fe7ea6000036/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c5959d524ae9500000c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aaf6c589a76f0e6fa00000c/800x.webp?source_format=jpg','house','Product',5,21),
(6,'貓咪小窩禮物盒',1500,'萌萌甜蜜小貓屋粉紅馬卡龍色系在你的心上撒嬌跟你住一起好嗎','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773410abb90734004767/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773659d52418d5000bb1/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773c9a76f018be00062b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aab773d00fdde18bf004807/800x.webp?source_format=jpg','house','Product',4,21),
(7,'超精緻情人蛋糕浪漫禮物盒',1999,'今年情人節還不知道送對方什麼嗎？限量情人節浪漫手作奶油蛋糕禮物爆炸卡','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac0617069111bd81400/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac0617069111f150600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac2617069680fd47600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac261706958eafba700/800x.webp?source_format=jpg','house','Product',4,21),
(8,'有你就幸福 情人禮物盒',1390,'幸福不需要什麼承諾不需要天長地久不需要朝夕相伴只要我心中有你你心中有我','https://shoplineimg.com/559785a6e37ec6046a000017/588dc89959d524170e000710/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/588dc8999f9a4f027600e391/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/588dc8999f9a4f025200e1be/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/588dc89972fdc0fc33012b3c/800x.webp?source_format=jpg','house','Product',5,21),
(9,'手作驚喜禮物盒',1490,'可愛的配色，充滿愛的泡泡，一直很想送一個禮物盒給最愛的他/她，可是好複雜不知道怎麼開始。','https://shoplineimg.com/559785a6e37ec6046a000017/5940e2139f9a4f491900401a/800x.jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5940e213d4e3957757008827/800x.jpg?','https://shoplineimg.com/559785a6e37ec6046a000017/5940e2129f9a4f992f00872f/800x.jpg?','https://shoplineimg.com/559785a6e37ec6046a000017/5940e2136ef2d4832d001b76/800x.jpg?','house','Product',6,21),
(10,'巧克力方格濃情禮物盒',990,'你是我的本命巧克力一格一格融進的心意情迷絲滑，專屬此刻','https://shoplineimg.com/559785a6e37ec6046a000017/5abc9bc372fdc0475d001a9b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abc9bc210abb9ea91001e0c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abc9bc68d1db92f46002126/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abc9bc259d52418fb000937/800x.webp?source_format=jpg','house','Product',5,21),

(11,'甜蜜蛋糕禮物盒',1990,'心中有特別想法，給特別的他?讓設計師親自幫你設計吧！','https://shoplineimg.com/559785a6e37ec6046a000017/58f73ff6d4e395da40000beb/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58f73fe3d4e395da3d000d33/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58f73fee72fdc0e374000f92/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa89c4f00fddec65c000136/800x.webp?source_format=jpg','house','Product',5,21),
(12,'絕美手工宇宙禮物盒',2080,'你的眼眸如星辰般燦爛願醉倒在這樣的夢幻場景像珠寶盒一般，細細珍藏','https://shoplineimg.com/559785a6e37ec6046a000017/5aa89c4e0e64fe09dc000153/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa89c4e00fddec6080001cb/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa89c4f4e22a62bcd00012c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa89c4f00fddec65c000136/800x.webp?source_format=jpg','house','Product',6,21),
(13,'超精緻情人蛋糕浪漫禮物盒',1999,'今年情人節還不知道送對方什麼嗎？限量情人節浪漫手作奶油蛋糕禮物爆炸卡','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac0617069111bd81400/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac061706911197f0600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5ac061706911134e0600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/578f5abe61706920e06ada00/800x.webp?source_format=jpg','house','Product',5,21),
(14,'DIY禮物盒材料包 一刀未剪',690,'這份一刀未剪版真正讓你有種”從頭到尾都是我做的唷“的驕傲','https://shoplineimg.com/559785a6e37ec6046a000017/59c35b9f59d524182c0005fe/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5892c7f472fdc0fc2e023d77/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5892c7f459d524170f000d15/800x.webp?source_format=jpg','https://s10.postimg.org/d8txfglp5/image.jpg','house','Product',2,21),
(15,'加卡娜赫拉玩偶禮物盒',1999,'療癒系教主席捲全亞洲  兔兔P助可愛登場','https://shoplineimg.com/559785a6e37ec6046a000017/5910414159d5244caf0004d5/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/59104141d4e3959eea0011f4/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591041426ef2d4a1e00004cd/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591041436ef2d4604e001670/800x.webp?source_format=JPG','house','Product',8,21),
(16,'手工禮物盒加snoopy玩偶',1999,'讓史努比幫你把這句句想與夥伴共勉勉的話傳遞出去吧','https://shoplineimg.com/559785a6e37ec6046a000017/59103f3759d5244caf00045e/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/59103f3872fdc0a58f001f85/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/59103f389a76f01736000f4d/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/59103f39d4e395fa7200074f/800x.webp?source_format=jpg','house','Product',7,21),

(17,'手工禮物盒加皮卡丘玩偶',1999,'可愛皮卡丘在禮物盒裡面幹嘛呢？醞釀著十萬伏特把最棒的祝福送給你啦~','https://shoplineimg.com/559785a6e37ec6046a000017/591043b559d5247065001536/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591043b56ef2d4f58b000a6a/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591043b672fdc0a53a002145/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591043b772fdc0a545001f11/800x.webp?source_format=JPG','house','Product',2,21),
(18,'手工禮物盒加史迪奇玩偶',1999,'史迪奇禮物盒讓史迪奇為你送上這份最真摯又可愛的祝福吧！','https://shoplineimg.com/559785a6e37ec6046a000017/591042ba6ef2d4f58b000a13/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591042ba9a76f0171e000fb0/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591042bb72fdc058b4000b93/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/591042bc72fdc0a58b001f01/800x.webp?source_format=JPG','house','Product',7,21),
(19,'超酷ATM提款機造型卡片盒',2099,'我對你的愛~可以無限提領~','https://shoplineimg.com/559785a6e37ec6046a000017/58f7237359d524efd20006cb/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58f72375d4e395754600033c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cb98479a76f0176d0011b0/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58f7237359d524efd20006cb/800x.webp?source_format=jpg','house','Product',5,21),
(20,'聖誕麋鹿禮物盒',1890,'敲口愛的麋鹿～陪你一起過聖誕節','https://shoplineimg.com/559785a6e37ec6046a000017/584a4c3f6170691710be0600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/584a4c4061706903bed40700/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/584a4c3f61706917316e0600/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/584a4c4061706903c7420900/800x.webp?source_format=jpg','house','Product',4,21),

(21,'偶像ＫＩＳＳ滑塊卡',599,'超甜蜜親親ＫＩＳＳ卡片全部由設計是純手工製作唷','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0ef7900fdde8d63000722/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0ef794e22a660ab000834/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0ef789a76f04d1d000728/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f5779a76f04d2b0007bd/800x.webp?source_format=jpg','card','Product',5,21),
(22,'立體相機手工書',630,'拍下回憶的瞬間把此刻的美好收藏起來','https://shoplineimg.com/559785a6e37ec6046a000017/5a6800645521150a22001e67/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a68006b9f9a4f144a001de5/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a68006859d52418c1000312/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6800695521150a7d001cfc/800x.webp?source_format=jpg','card','Outlet',5,10),
(23,'親親驚喜手作抽拉卡',780,'計師純手工設計為情人節特別設計款也適合送給閨蜜唷商品少量現貨供應中！','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b25521156aae000b21/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b1080f0652fe000a43/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b39f9a4ffbf5000915/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a6ed6b572fdc0b0df0009f9/800x.webp?source_format=jpg','card','Product',5,21),
(24,'偶像彈跳驚喜卡',699,'超甜蜜親親ＫＩＳＳ卡片全部由設計是純手工製作唷','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f1560e64fed3ff000785/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f15610abb989f30007fc/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f1569a76f04cf0000861/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa0f15610abb98a09000863/800x.webp?source_format=jpg','card','Product',7,21),
(25,'籃球手作卡片',799,'萬眾期待！籃球卡片來啦~送籃球控這款準沒錯~','https://shoplineimg.com/559785a6e37ec6046a000017/58cf677959d5241733000a72/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cf677559d524173f000944/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cf677559d5241748000a9e/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58cf6776d4e395a183001c34/800x.webp?source_format=jpg','card','Product',5,21),

(26,'辣妹愛你機關手作卡',699,'火辣辣辣妹愛情手做卡 今年卡片來點不一樣的吧','https://shoplineimg.com/559785a6e37ec6046a000017/595f3770d4e3957b6e0000d3/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/595f37709a76f060930000c3/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/595f37709a76f0a32b000008/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/595f3770552115c636000181/800x.webp?source_format=jpg','card','Product',5,21),
(27,'簡約機關手作書卡',420,'沁新的白 因為你漸漸有了色彩 想送你滿扉頁的回憶','https://shoplineimg.com/559785a6e37ec6046a000017/5abb0bce8d1db94984002ee5/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abb0bce4e22a68c52003ce6/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abb0bce0e64fe9a58004456/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abb0bce0e64fe873100145b/800x.webp?source_format=jpg','card','Product',4,21),
(28,'IG書頁造型',840,'最寧靜的小天堂 最美的社群軟體 而你是我的小幸運','https://shoplineimg.com/559785a6e37ec6046a000017/5abaf62e0e64fe9ab3003909/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abaf62a00fdde246c0039b6/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abaf62e0e64fe9af1003c34/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abaf62a00fdde2444003bc7/800x.webp?source_format=jpg','card','Product',7,21),
(29,'簡單愛。手工書',590,'愛說不出口沒關係 將你的愛寫成一本書','https://shoplineimg.com/559785a6e37ec6046a000017/5819e06161706994d0e55100/800x.jpg?','https://shoplineimg.com/559785a6e37ec6046a000017/5819e061617069176d2f1700/800x.jpg?','https://shoplineimg.com/559785a6e37ec6046a000017/586c960ad4e39506270005ac/800x.jpg?','https://shoplineimg.com/559785a6e37ec6046a000017/586c960a72fdc008fc0005a6/800x.jpg?','card','Product',6,21),
(30,'豬寶貝手作卡',799,'豬豬寶～我最愛你了~快接招我的小情書吧！','https://shoplineimg.com/559785a6e37ec6046a000017/5940e47f6ef2d4957b00ac08/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5940e47bd4e395774f008f67/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5940e47b6ef2d495a900a980/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5940e47b59d5241729000a6f/800x.webp?source_format=jpg','card','Product',5,21),

(31,'嫁給我~MARRY ME 手作機關卡',799,'每每看到卡片就能回想起我們在一起的點滴跟求婚的那天','https://shoplineimg.com/559785a6e37ec6046a000017/591925f7d4e3954b0800dc47/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/591925f172fdc0f63300da0c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/591925f0d4e395bc08002938/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/591925f0d4e395f7bf000bc4/800x.webp?source_format=jpg','card','Product',4,21),
(32,'草莓蛋糕手作生日卡',780,'想給你一個最棒的祝福 甜甜的草莓蛋糕裡面 藏著我對妳的愛','https://shoplineimg.com/559785a6e37ec6046a000017/58dc7b92115350170b000837/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/58dc7b9259d5241744000496/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/58dc7b901153501735000840/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/58dc7b9011535017410007ca/800x.webp?source_format=JPG','card','Product',5,21),
(33,'許個心願吧~蠟燭手作生日卡',490,'吹熄蠟燭許願吧 想把最好的願望都留給你 希望你天天開心','https://shoplineimg.com/559785a6e37ec6046a000017/58ca53489a76f03a68000551/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca534759d524eb70000c5f/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca534772fdc0fc64000e2e/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca534459d524eb96000b46/800x.webp?source_format=jpg','card','Product',5,21),

(34,'甜甜蛋糕手作生日卡',490,'送你兩個小蛋糕，記得許下今年的願望，希望可以永遠幸福快樂！','https://shoplineimg.com/559785a6e37ec6046a000017/58ca593959d524eb85000e75/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca5936d4e395f52c000c96/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca5937115350170e0007c3/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca5937115350171a0009a2/800x.webp?source_format=jpg','card','Product',4,21),
(35,'復古掌上型遊樂器卡片',600,'超級可愛的一款機關卡片，可以寫上很多故事跟貼上很多照片!','https://shoplineimg.com/559785a6e37ec6046a000017/57e432ea6170690936051900/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/57e432ea617069602d3c1500/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/57e432ea617069310a281700/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/57e432e96170692dac7c1600/800x.webp?source_format=jpg','card','Product',5,21),
(36,'英倫風~雙層巴士造型手作卡',490,'超Q的英倫風卡片 雙層巴士要載我們去哪玩呢? 跟著紳士一起旅遊吧!','https://shoplineimg.com/559785a6e37ec6046a000017/58ca4f6672fdc0fc460010de/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca4f6659d524eb73000e7d/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca4f649a76f0125c000eaf/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58ca4f6a72fdc0fc29000dd9/800x.webp?source_format=jpg','card','Product',5,21),
(37,'手作生日卡片',850,'圖片上的照片、紙膠帶、繪畫僅供參考 ','https://shoplineimg.com/559785a6e37ec6046a000017/58be516059d5241740000bd0/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/58be51c1d4e395bb9e00452b/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/58be526159d5241722000db8/800x.webp?source_format=JPG','https://shoplineimg.com/559785a6e37ec6046a000017/58be526072fdc04e39001baa/800x.webp?source_format=JPG','card','Product',5,21),
(38,'手工底片相簿卡',390,'把照片和文字貼上，讓每個回憶永遠都生動的存在著','https://shoplineimg.com/559785a6e37ec6046a000017/56cc13df6170690ec4841500/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/56cc13e261706904f9d60400/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/56cc13e26170690516290500/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/56cc13e36170690ea2402100/800x.webp?source_format=jpg','card','Product',5,21),
(39,'小黑貓的特別尾巴萬用卡',590,'超可愛的黑貓 獻給超可愛的她','https://shoplineimg.com/559785a6e37ec6046a000017/583d02a96170695c5eab0300/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/583d02aa617069f7c3b70300/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/583d02aa617069a654d80300/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/583d02aa6170691766d20000/800x.webp?source_format=jpg','card','Product',5,21),
(40,'瀑布小卡片',350,'你有多久沒親手寫一張卡片了呢 快來寫一張卡片給你在乎的人吧','https://shoplineimg.com/559785a6e37ec6046a000017/56e9116e6170694189470400/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/56e911a961706914d1080500/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/56e9119361706962c4f60300/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/56e911c76170695000f50400/800x.webp?source_format=jpg','card','Product',5,21),

(41,'小象膠帶台',840,'跟著俏皮小象天天玩耍作伴，一起擁有踏實美好的一天吧。','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf4699a76f083dd000582/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf46810abb9ea08003c74/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf4698d1db92f0f004059/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf46a10abb9ea4a0037ca/800x.webp?source_format=jpg','cute','Product',5,21),
(42,'朵朵雲兒收納壁掛',350,'朵朵雲兒的日常可愛的雲兒寶寶，總是出現在大門邊，以備不時之需！','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf2f00e64febb5a00303c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf2ee59d52418a4000a70/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf2ee10abb9ea360037b2/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdf2ee9a76f018db00066d/800x.webp?source_format=jpg','cute','Product',10,21),
(43,'童話世界｜棉花棒罐',480,'純白雪地裡的動物正緩緩前行著，像是森林裡的守護精靈，撫慰著大地之母的期盼。','https://shoplineimg.com/559785a6e37ec6046a000017/5abdef428d1db9f6630017d4/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdef4200fddeb71c003c5d/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdef414e22a673c6004087/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5abdef420e64fe8c6d00014c/800x.webp?source_format=jpg','cute','Product',10,21),
(44,'創意景觀雙層玻璃水瓶',499,'春天了，帶上它去踏青吧~','https://shoplineimg.com/559785a6e37ec6046a000017/5aa77d0b00fdde9760001dfb/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa77b0c0e64fe8d7a00160b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa77b0c9a76f018f600048a/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5aa77b0c72fdc07fbf001b6f/800x.webp?source_format=jpg','cute','Product',10,21),
(45,'會跳舞唱歌吹樂器的向日葵',490,'超逗趣的一款向日葵 讓你一見我就笑!','https://shoplineimg.com/559785a6e37ec6046a000017/5a9f59b100fddeabc3000052/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a9f59af0e64fe8a3c00002b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a9f59af59d524e19000002c/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a9f59ae59d524e169000062/800x.webp?source_format=jpg','cute','Product',10,21),
(46,'旺仔趣味小夜燈',890,'可愛旺仔的笑容是不是讓人超融化的呢','https://shoplineimg.com/559785a6e37ec6046a000017/5a99235f9a76f018e00008a3/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a99235d00fdde05b2002729/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a99235e8d1db9192f0029a9/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a9923600e64fe18ad0026e9/800x.webp?source_format=jpg','cute','Product',10,21),
(47,'仿真磚頭抱枕',190,'超逼真的磚頭樣子自己動手蓋個磚頭屋吧','https://shoplineimg.com/559785a6e37ec6046a000017/5a8e3b3bd4e39580420026fe/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a8e3b3b552115705c002269/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a8e3b3a72fdc010810023fc/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a8e3b3a59d52418f60002b2/800x.webp?source_format=jpg','cute','Product',10,21),
(48,'打地鼠創意小夜燈',690,'可愛模樣及趣味開機方式 讓夜晚不再寂寞可怕','https://shoplineimg.com/559785a6e37ec6046a000017/5a82bff955211541f0000bd6/800x.webp?source_format=gif','https://shoplineimg.com/559785a6e37ec6046a000017/5a82c0c8080f06274d000ded/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a82bff455211541ff000d21/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a82bff572fdc05fff000c23/800x.webp?source_format=jpg','cute','Product',10,21),
(49,'拉拉熊造型毛襪',220,'拉拉熊造型毛襪 高筒小耳朵超可愛 毛絨絨材質溫暖舒服 腳底止滑設計','https://shoplineimg.com/559785a6e37ec6046a000017/58c7755a9a76f0170c000230/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58c7755b72fdc05651005b7b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58c7755b115350173a00064b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/58c7755b72fdc05673005b90/800x.webp?source_format=jpg','cute','Product',10,21),
(50,'萌萌貓掌暖手行動電源',990,'暖 從這一刻開始 看書時,再不怕手凍 不管上班 家裡 逛街  看書都能享受溫暖','https://shoplineimg.com/559785a6e37ec6046a000017/5a655fb99f9a4f4fae0001d2/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a655fbdd4e3957fd50001b1/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a655fd39f9a4f4f6e0001b4/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a655fd359d524a265000165/800x.webp?source_format=jpg','cute','Product',10,21),
(51,'打翻的星巴克奶茶手機支架',480,'此商品為手工製作 每個奶茶的形狀都會不一樣 隨機灑出的狀態','https://shoplineimg.com/559785a6e37ec6046a000017/5a5c324859d524c87100036f/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a5c32489a76f018a0000143/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a5c32546ef2d48714000398/800x.webp?source_format=png','https://shoplineimg.com/559785a6e37ec6046a000017/5a5c3248080f06d18f00039e/800x.webp?source_format=jpg','cute','Product',10,21),
(52,'牛奶伴睡留言燈',570,'贈送可擦拭擦擦筆 可寫字在牛奶瓶內留言唷 最貼心的小夜燈','https://shoplineimg.com/559785a6e37ec6046a000017/5a27d9b69a76f01804000c7f/800x.webp?source_format=PNG','https://shoplineimg.com/559785a6e37ec6046a000017/5a27d9909a76f017f2000d88/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a27d9785521159113000e5a/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a27d9a44926783beb000f8d/800x.webp?source_format=jpg','cute','Product',10,21),
(53,'帶磁性仙人掌收納筆筒',550,'帶磁性可吸附迴紋針等物 商品會因顯示器不同而有些微色差，請見諒 ','https://shoplineimg.com/559785a6e37ec6046a000017/5a26b6636ef2d4e85600139b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a26b660080f06b13c003d26/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a26b65c72fdc0ad91003d81/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/5a26b65a595630182e0006de/800x.webp?source_format=jpg','cute','Product',10,21),
(54,'毛小孩的寵物香蕉床墊',590,'香蕉窩尺寸：60*35*10 窩和墊子是分開設計,拆洗方便唷','https://shoplineimg.com/559785a6e37ec6046a000017/59f2e7e1d4e39508f300ecf5/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59f2e7e29a76f01827000173/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59f2e7e059d524181500074b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59f2e7e172fdc065a40114e3/800x.webp?source_format=jpg','cute','Product',10,21),
(55,'鏟屎官必備，吐司墊',590,'材質：外部(水晶超柔)；內部(高彈性海綿) 寵物窩墊(貓狗通用)','https://shoplineimg.com/559785a6e37ec6046a000017/59e0cbed72fdc002730027b3/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59e0cbfb59d52417dd00108b/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59e0cbd45521154232002cff/800x.webp?source_format=jpg','https://shoplineimg.com/559785a6e37ec6046a000017/59e0cc2955211541e500306d/800x.webp?source_format=jpg','cute','Product',10,21);


DROP TABLE IF EXISTS `vgb`.`orders`;
CREATE TABLE  `vgb`.`orders` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` char(10) NOT NULL,
  `order_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `payment_type` varchar(10) NOT NULL,
  `payment_fee` int(10) unsigned DEFAULT '0',
  `payment_note` varchar(100) DEFAULT NULL,
  `shipping_type` varchar(10) NOT NULL,
  `shipping_fee` int(10) unsigned DEFAULT '0',
  `shipping_note` varchar(100) DEFAULT NULL,
  `receiver_name` varchar(20) NOT NULL,
  `receiver_email` varchar(45) NOT NULL,
  `receiver_phone` varchar(30) NOT NULL,
  `shipping_addr` varchar(100) NOT NULL,
  `status` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_orders_to_customers` (`customer_id`),
  CONSTRAINT `FK_orders_to_customers` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `vgb`.`order_items`;
CREATE TABLE  `vgb`.`order_items` (
  `order_id` int(10) unsigned NOT NULL,
  `product_id` int(10) unsigned NOT NULL,
  
  `price` double NOT NULL,
  `quantity` int(10) unsigned NOT NULL,
  PRIMARY KEY (`order_id`,`product_id`),
  KEY `FK_order_items_to_products` (`product_id`),
  CONSTRAINT `FK_order_items_to_orders` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_order_items_to_products` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 確實已存在orders table, 且其中有status欄位  */
DROP TABLE IF EXISTS `order_status_log`;
CREATE TABLE  `order_status_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `old_status` int(10) unsigned NOT NULL,
  `new_status` int(10) unsigned NOT NULL,
  `old_payment_note` varchar(100) DEFAULT NULL,
  `new_payment_note` varchar(100) DEFAULT NULL,
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TRIGGER IF EXISTS `log_orders_status`;
CREATE TRIGGER log_orders_status AFTER UPDATE ON orders FOR EACH ROW
    INSERT INTO order_status_log(order_id, old_status, new_status, old_payment_note, new_payment_note) 
		VALUES (new.id, old.status, new.status, old.payment_note,new.payment_note);