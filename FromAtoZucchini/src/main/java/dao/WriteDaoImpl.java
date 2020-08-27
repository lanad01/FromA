package dao;

import java.util.Calendar;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.Condition;
import model.ImageWriting;
@Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;
	public void updateImage(ImageWriting w) {
		session.update("mapper.uploadMapper.updateImage",w);
	}
	public void deleteImage(Integer id) {
		session.delete("mapper.uploadMapper.deleteImage",id);
	}
	public ImageWriting getImageWriting(Integer seqno) {
		return session.selectOne("mapper.uploadMapper.getImageRead", seqno);
	}
	public List<ImageWriting> getImageList(Condition c) {
		return session.selectList(
				"mapper.uploadMapper.getImageReplyCondition",c);
	}
	public Integer getTotalImage() {
		return session.selectOne("mapper.uploadMapper.getTotalCnt");
	}
	public Integer getRownum(Integer seqno) {
		return session.selectOne(
				"mapper.uploadMapper.selectRownumBySeqno", seqno);
	}
	public void updateOrderNo(ImageWriting w) {
		session.update("mapper.uploadMapper.updateOrderNoReply", w);
	}
	public Integer getImageMaxId() {
		return session.selectOne("mapper.uploadMapper.getMax");
	}
	public void insertImage(ImageWriting w) {
		session.insert("mapper.uploadMapper.putImageReply",w);
	}
	public Integer getImageMaxGrId() {
		return session.selectOne("mapper.uploadMapper.getMaxGr");
	}
	public Integer getMaxId() {
		return session.selectOne("mapper.myMapper.getSeqno");
	}
	public void insertBBS(Bbs bbs) {
		Integer seqno = this.getMaxId();
		if(seqno == null) seqno = 0;
		seqno = seqno + 1;
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH) + 1;
		int date = today.get(Calendar.DATE);
		String bbsDate = year+"/"+month+"/"+date;
		bbs.setSeqno(seqno);//글번호 설정
		bbs.setRegister_date(bbsDate);//작성일 설정
		session.insert("mapper.myMapper.insertBBS", bbs);//DB에 삽입
	}

}
























