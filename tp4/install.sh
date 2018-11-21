sudo apt update

# install venv
sudo apt-get install python-virtualenv -y

# create venv
python -m virtualenv venv
. venv/bin/activate

# install dependencies
pip --no-cache-dir install pyspark==2.3.2
pip install Flask

