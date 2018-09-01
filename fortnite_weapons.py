import sys
import os
import argparse
from urllib.request import urlopen
from bs4 import BeautifulSoup as soup
import json


def args():
    parser = argparse.ArgumentParser()

    parser.add_argument("-img",
                        help = "Specify if images should be downloaded 0 - without images, 1 - images 120px, 2 - images 240px, 3 - images 360px.",
                        type = int,
                        default = 0)

    return parser.parse_args()

class Weapon(object):
    name = ""
    weapon_type = ""
    image_url = ""
    image_file_name = ""
    rarity = ""
    bullet_type = ""
    dps = ""
    damage = ""
    fire_rate = ""
    magazine_size = ""
    reload_time = ""
    structure_damage = ""

    def toJSON(self):
        return json.dumps(self, default=lambda o: o.__dict__, indent=4)



def main(img):
    url = "https://fortnite.gamepedia.com/Battle_Royale_Weapons"
    client = urlopen(url)
    page_html = client.read()
    client.close()

    image_size = 120
    if img == 2:
        image_size = 240
    elif img == 3:
        image_size = 360
        

    page = soup(page_html, "html.parser")
    weaponsDiv = page.findAll("div", {"id" : "mw-content-text"})

    weapons = weaponsDiv[0].findAll("table", {"class" : "miniinfoboxtable"})
    weaponList = list()

    for weapon in weapons:
        weaponObj = Weapon()
        weaponObj.weapon_type = weapon.find_previous("h2").span.string.strip()
        weaponObj.name = weapon.find("th", {"class" : "infoboxname"}).a.string.strip()
        weaponObj.image_url = weapon.find("th", {"class" : "infoboxfieldimage"}).a.img["src"].replace("80px", str(image_size) + "px")
        weaponDetails = weapon.findAll("tr", {})
        for weaponAtr in weaponDetails:
            if weaponAtr.find("td", {"class" : "infoboxfieldname"}) != None:
                atrs = weaponAtr.findAll("td", {})
                if atrs[0].text.strip() == "Bullet Type":
                    weaponObj.bullet_type = atrs[1].span.a["title"].strip()
                elif atrs[0].text.strip() == "Rarity":
                    weaponObj.rarity = atrs[1].text.strip()
                elif atrs[0].text.strip() == "DPS":
                    weaponObj.dps = atrs[1].text.strip()
                elif atrs[0].text.strip() == "Damage":
                    weaponObj.damage = atrs[1].text.strip()
                elif atrs[0].text.strip() == "Fire Rate":
                    weaponObj.fire_rate = atrs[1].text.strip()
                elif atrs[0].text.strip() == "Reload Time":
                    weaponObj.reload_time = atrs[1].text.strip()
                elif atrs[0].text.strip() == "Structure Damage":
                    weaponObj.structure_damage = atrs[1].text.strip()
                elif atrs[0].text.strip() == "Magazine Size":
                    if(all(ord(c) < 128 for c in atrs[1].text.strip())):
                        weaponObj.magazine_size = atrs[1].text.strip()
                    else:
                        weaponObj.magazineSize = "N/A"

        weaponList.append(weaponObj)

    if img > 0:
        index = 0
        weapon_image_urls = {weapon.image_url for weapon in weaponList}
        for image_url in weapon_image_urls:
            index += 1
            image_file_name = download_image(next(weapon for weapon in weaponList if weapon.image_url == image_url), index)
            for weapon in weaponList:
                if weapon.image_url == image_url:
                    weapon.image_file_name = image_file_name
        
        

    jsonFile = open("weapons.json", "w")
    jsonFile.write(json.dumps(weaponList, default = lambda x: x.__dict__, indent=4))
    jsonFile.close()


def download_image(weapon, index):
    file_name = ""
    try:
        image_web = urlopen(weapon.image_url)
        if image_web.headers.get("content-type") == "image/png":
            buffer = image_web.read()
            path = os.path.join(os.getcwd() + "/images/")
            if not os.path.exists(path):
                os.mkdir(path)
            file_name = "{}_{}.png".format(weapon.name.replace(" ", "_").lower(), str(index).zfill(2))
            file_path = "{}{}".format(path, file_name)
            image_local = open(file_path, "wb")
            image_local.write(buffer)
            image_local.close()
            image_web.close()
    except:
        return ""
    return file_name


if __name__ == "__main__":
    args = args()
    main(args.img)

















