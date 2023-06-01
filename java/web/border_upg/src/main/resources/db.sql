select * from TBL_STORE
;
select owid, sno from TBL_OWNER;

select store.sno, sname, owner.OWID, pnum, lng,lat,addr
from (select owid, sno from TBL_OWNER) owner, TBL_STORE store
where store.sno = owner.sno