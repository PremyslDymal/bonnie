##### Run Postgres *
`ssh ${USER}@bonniee.eu`
##### Create and run a docker container:
`docker run -d --name "${USER}_postgres" -p 127.0.0.1:15432:5432 -e POSTGRES_PASSWORD=doodle -e POSTGRES_USER=doodle -v /home/$USER/postgres/db:/var/lib/postgresql/data postgres`

p.s. make sure the port (15432) is unused aka free, if that port is busy, pick another available port 
##### Once the Postgres container is running then the port can be verified:
1. `ssh -N ${USER}@bonnee.eu -L 5432:127.0.0.1:15432`
2. `telnet localhost 5432`