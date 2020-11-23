CREATE TABLE IF NOT EXISTS `shopdb`.`auction` (
  `id_auction` INT NOT NULL,
  `type` VARCHAR(45) NULL,
  `product_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id_auction`, `product_id`, `user_id`),
  INDEX `fk_Auction_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_Auction_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_Auction_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `mydb`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Auction_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB