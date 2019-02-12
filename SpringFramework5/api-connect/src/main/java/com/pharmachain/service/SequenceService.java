package com.pharmachain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.pharmachain.domain.Sequence;
import com.pharmachain.exception.SequenceException;

@Service
public class SequenceService {

	@Autowired
	private MongoOperations mongoOperation;
	
	public static final String COMPANY_SEQ_KEY = "company";
	public static final String STORE_SEQ_KEY = "store";
	public static final String USER_SEQ_KEY = "users";
	public static final String PROSPECT_STORE_SEQ_KEY = "prospect_store";

	public long getNextSequenceId(String key) throws SequenceException {
		
		//Get sequence id
		Query query = new Query(Criteria.where("_id").is(key));

		//Increase sequence id by 1
		Update update = new Update();
		update.inc("seq", 1);

		//Return new increased id
		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);
		options.upsert(true);

		//This is the magic happened.
		Sequence seqId = mongoOperation.findAndModify(query, update, options, Sequence.class);

		//if no id, throws SequenceException
		if (seqId == null) {
			throw new SequenceException("", "Unable to get sequence id for key : " + key);
		}
		return seqId.getSeq();
	}
}
